package com.modula.common.domain.moduleconfiguration;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.UUID;

/**
 * Represents the configuration metadata for an external integration module.
 * This configuration includes display information, API access points,
 * authentication type,
 * and associated actions and triggers.
 */
@Entity
@Data
@Inheritance(strategy = InheritanceType.JOINED)
public class ModuleConfiguration {

        @Id
        @GeneratedValue(strategy = GenerationType.UUID)
        private UUID id;

        /**
         * List of available module actions provided by the module.
         */
        @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
        @JoinTable(name = "module_configuration_actions", joinColumns = @JoinColumn(name = "module_configuration_id"), inverseJoinColumns = @JoinColumn(name = "actions_id"))
        private List<ModuleAction> actions;

        /**
         * List of available module triggers (webhooks) provided by the module.
         */
        @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
        @JoinTable(name = "module_configuration_triggers", joinColumns = @JoinColumn(name = "module_configuration_id"), inverseJoinColumns = @JoinColumn(name = "triggers_id"))
        private List<ModuleTrigger> triggers;
}