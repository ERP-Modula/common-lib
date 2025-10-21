package com.modula.common.domain.moduleconfiguration;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Data;

@Entity
@Data
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "name"))
public class Module {
  /**
   * Unique identifier for the module configuration.
   */
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  /**
   * Unique system name for the module (e.g., "bitrix", "google").
   */
  private String name;

  /**
   * Human-readable label (e.g., "Bitrix24 CRM").
   */
  private String label;

  /**
   * Detailed description of the module.
   */
  private String description;

  /**
   * Path to the module's icon (e.g., "/icons/bitrix.png").
   */
  private String iconPath;

  /**
   * S3 object key for the module's logo (e.g., "logos/telegram/v1/icon.svg").
   * The actual URL should be resolved via CDN/object storage configuration.
   */
  private String logoKey;

  /**
   * Indicates if the module is publicly visible.
   */
  private Boolean isPublic;

  /**
   * Theme color of the module (e.g., "blue", "#FF5733").
   */
  private String theme;

  /**
   * Identifier of the author or system that created the module.
   */
  private String authorId;
  /**
   * Categories to which the module belongs (e.g., ["crm", "sales"]).
   */
  @ElementCollection()
  @CollectionTable(name = "module_categories", joinColumns = @JoinColumn(name = "module_id"))
  @Column(name = "category")
  private List<String> categories;

  @ElementCollection()
  @CollectionTable(name = "module_keywords", joinColumns = @JoinColumn(name = "module_id"))
  @Column(name = "keyword")
  private List<String> keywords;

  @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "module")
  private List<ModuleVersion> versions;

  /**
   * Timestamp when the module was created.
   */
  private LocalDateTime createdAt;

  /**
   * Timestamp when the module was last updated.
   */
  private LocalDateTime updatedAt;
}
