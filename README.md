# common-lib

Для публикации нужен токен доступа github, для его получения используется GitHub CLI (gh):

Перед использованием нужно авторизоваться и получить токен с правами "write:packages" для публикации или "read:packages" для подключения библиотеки.

`!!! write:packages включает в себя read:packages, второй раз прописывать не надо`

```shell
gh auth refresh --scopes "write:packages" # для публикации и подключения
gh auth refresh --scopes "read:packages" # только для подключения
```

## Публикация новой версии common-lib:
Изменить версию в `build.gradle`:
```gradle
group = 'com.modula'
version = 'X.X.X' // например 1.0.0
```

В консоли прописать:
```shell
./gradlew publish
```

## Подключение common-lib в стороннем gradle проекте:
В `gradle.build` добавить:
```gradle
def ensureTokenHasReadPackages() {
	try {
		def proc = "gh auth status".execute()
		proc.waitFor()
		def statusOutput = proc.in.text
		if (statusOutput.contains("read:packages") || statusOutput.contains("write:packages")) {
			return;
		}
		throw new GradleException()
	} catch(Exception e) {
		logger.warn("Failed to check token scopes via 'gh auth status'", e)
		throw new GradleException("❌ Token does not have the required 'read:packages' scope. Please run: gh auth refresh --scopes \"read:packages\"")
	}
}

def getGithubToken() {
	ensureTokenHasReadPackages()
	def token = System.getenv("GITHUB_TOKEN")
	if (!token) {
		try {
			def proc = "gh auth token".execute()
			proc.waitFor()
			token = proc.in.text.trim()
		} catch (Exception e) {
			logger.warn("Failed to get GitHub token via gh", e)
		}
	}
	println("Token: ${token[0..3]}${'*' * (token.length() - 9)}${token[-5..-1]}")
	return token ?: ""
}

def getGithubUser() {
	def user = System.getenv("GITHUB_USER")
	if (!user) {
		try {
			def proc = "gh api user --jq .login".execute()
			proc.waitFor()
			user = proc.in.text.trim()
		} catch (Exception e) {
			logger.warn("Failed to get GitHub username via gh", e)
		}
	}
	println("Username: ${user}")
	return user ?: ""
}

repositories {
	mavenCentral()
	maven {
		url = uri("https://maven.pkg.github.com/ERP-Modula/common-lib")
		credentials {
			username = getGithubUser()
			password = getGithubToken()
		}
	}
}

dependencies {
	implementation 'com.modula:common-lib:1.0.0'
    // other libs
}
```

P.S: к сожалению, команда GitHub с 2022 года не может выпусть fine-granted tokens с правами на чтение/запись packages для организаций, поэтому приходится так костылить. (https://github.com/github/roadmap/issues/558)