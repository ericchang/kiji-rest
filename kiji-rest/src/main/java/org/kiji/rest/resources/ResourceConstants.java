/**
 * (c) Copyright 2013 WibiData, Inc.
 *
 * See the NOTICE file distributed with this work for additional
 * information regarding copyright ownership.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.kiji.rest.resources;

/**
 * Utility class containing constants relevant to resource paths.
 */
public final class ResourceConstants {
  /** The namespace for api. */
  private static final String API_ENTRY_POINT = "/v1/";

  /** The namespace for instances. */
  private static final String INSTANCES = "instances/";

  /** The namespace for tables. */
  private static final String TABLES = "tables/";

  /** The namespace for scanners. */
  private static final String SCANS = "scans/";

  /** The namespace for rows. */
  private static final String ROWS = "rows/";

  /**
   * GETs a message containing a list of the available sub-resources.
   * <li>Path: /v1/
   * <li>Handled by: {@link KijiRESTResource#getRoot}
   */
  public static final String API_ENTRY_PATH = API_ENTRY_POINT;

  /**
   * GETs version information.
   * <li>Path: /v1/version
   * <li>Handled by: {@link KijiRESTResource#getVersion}
   */
  public static final String VERSION_ENDPOINT = "version";

  /**
   * GETs a list of instances that are available.
   * <li>Path: /v1/instances/
   * <li>Handled by: {@link InstanceResource#getInstanceList()}
   */
  public static final String INSTANCES_PATH =
      API_ENTRY_PATH + INSTANCES;

  /**
   * GETs instance level metadata.
   * <li>Path: /v1/instances/{instance}/
   * <li>Not handled.
   */
  public static final String INSTANCE_PARAMETER = "instance";
  public static final String INSTANCE_SUBPATH = "{" + INSTANCE_PARAMETER + "}/";

  /**
   * GETs a list of tables in the specified instance.
   * <li>Path: /v1/instances/{instance}/tables/
   * <li>Handled by {@link TableResource#getTableList}
   */
  public static final String TABLES_PATH =
      INSTANCES_PATH  + INSTANCE_SUBPATH + TABLES;

  /**
   * GETs the layout of the specified table.
   * <li>Path: /v1/instances/{instance}/tables/{table}/
   * <li>Handled by: {@link TableResource#getTable}
   */
  public static final String TABLE_PARAMETER = "table";
  public static final String TABLE_SUBPATH = "{" + TABLE_PARAMETER + "}/";

  /**
   * GETs a hexadecimal EntityId using the components specified in the query.
   * <li>Path: /v1/instances/{instance}/tables/{table}/entityId
   * <li>Handled by: {@link TableResource#getEntityId}
   */
  public static final String ENTITY_ID_ENDPOINT = "entityId";

  /**
   * GETs a list of rows returned by the scanner.
   * <li>Path: /v1/instances/{instance}/tables/{table}/scans/
   * Handled by: {@link ScanResource#getScans}
   */
  public static final String SCANS_PATH =
      TABLES_PATH + TABLE_SUBPATH + SCANS;

  /**
   * Handles rows resources.
   * <li>Path: /v1/instances/{instance}/tables/{table}/rows/
   * <li>Handled by: {@link RowsResource}
   */
  public static final String ROWS_PATH =
      TABLES_PATH + TABLE_SUBPATH + ROWS;

  /**
   * GETs and PUTs a Kiji row specified by the hex entity id.
   * <li>Path: v1/instances/{instance}/tables/{table}/rows/<hexEntityId>
   * <li>Handled by: {@link RowsResource#getRowByHexEntityId}
   */
  /** Parameter for the hexEntityId of the row. */
  public static final String HEX_ENTITY_ID_PARAMETER = "hexEntityId";
  public static final String HEX_ENTITY_ID_SUBPATH = "{" + HEX_ENTITY_ID_PARAMETER + "}/";

  /** Utility class cannot be instantiated. */
  private ResourceConstants() {}
}


