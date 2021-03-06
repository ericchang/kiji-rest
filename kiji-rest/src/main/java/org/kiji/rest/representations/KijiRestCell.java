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

package org.kiji.rest.representations;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import org.hibernate.validator.constraints.NotEmpty;

import org.kiji.schema.KijiCell;

/**
 * Models what a Kiji cell looks like when returned to the client. The value property can
 * store one of three things (two data types but three unique meanings):
 * <ol>
 *   <li> Numbers (ints, longs, floats, doubles etc)
 *   <li> String literals
 *   <li> String literals that are JSON objects represented as escaped strings.
 * </ol>
 * The JSON string within a value is used when the underlying cell value is a more complex
 * Avro type (arrays, maps, unions, records). For more information about the JSON encoding
 * of Avro records, please consult the Avro
 * <a href="http://avro.apache.org/docs/current/spec.html#json_encoding">spec</a>. When setting
 * a cell value to a complex Avro type, please ensure that the string is properly escaped so that
 * it's not interpreted as a JSON object but rather as a JSON string.
 */
@JsonPropertyOrder({"columnFamily", "columnQualifier"})
public class KijiRestCell {

  @JsonProperty("timestamp")
  private Long mTimestamp;

  @NotEmpty
  @JsonProperty("columnFamily")
  private String mColumnFamily;

  @JsonProperty("columnQualifier")
  private String mColumnQualifier;

  @JsonProperty("value")
  private Object mValue;

  /**
   * Constructs a KijiRestCell given a KijiCell.
   *
   * @param kijiCell the incoming cell
   */
  public KijiRestCell(KijiCell<?> kijiCell) {
    mTimestamp = kijiCell.getTimestamp();
    mColumnFamily = kijiCell.getFamily();
    mColumnQualifier = kijiCell.getQualifier();
    mValue = kijiCell.getData();
  }

  /**
   * Constructs a new KijiRestCell from the components.
   * @param timestamp is the timestamp of the cell.
   * @param columnFamily is the columnFamily.
   * @param columnQualifier is the columnQualifier.
   * @param value is the value of the cell.
   */
  public KijiRestCell(Long timestamp, String columnFamily,
      String columnQualifier, Object value) {
    super();
    this.mTimestamp = timestamp;
    this.mColumnFamily = columnFamily;
    this.mColumnQualifier = columnQualifier;
    this.mValue = value;
  }

  /**
   * Dummy constructor required for Jackson to (de)serialize JSON properly.
   */
  public KijiRestCell() {
  }

  /**
   * Returns the underlying cell's timestamp.
   *
   * @return the underlying cell's timestamp
   */
  public Long getTimestamp() {
    return mTimestamp;
  }

  /**
   * Returns the underlying cell's column family.
   *
   * @return the underlying cell's column family
   */
  public String getColumnFamily() {
    return mColumnFamily;
  }

  /**
   * Returns the underlying cell's column qualifier.
   *
   * @return the underlying cell's column qualifier
   */
  public String getColumnQualifier() {
    return mColumnQualifier;
  }

  /**
   * Returns the underlying cell's column value.
   *
   * @return the underlying cell's column value
   */
  public Object getValue() {
    return mValue;
  }
}
