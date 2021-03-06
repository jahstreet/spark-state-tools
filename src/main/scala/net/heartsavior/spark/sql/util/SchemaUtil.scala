/*
 * Copyright 2019 Jungtaek Lim "<kabhwan@gmail.com>"
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package net.heartsavior.spark.sql.util

import org.apache.spark.sql.hack.SparkSqlHack
import org.apache.spark.sql.types.{DataType, StructType}

object SchemaUtil {
  def getSchemaAsDataType(schema: StructType, fieldName: String): DataType = {
    schema(SparkSqlHack.getFieldIndex(schema, fieldName).get).dataType
  }

  def keyValuePairSchema(keySchema: StructType, valueSchema: StructType): StructType =
    new StructType()
      .add("key", StructType(keySchema.fields), nullable = false)
      .add("value", StructType(valueSchema.fields), nullable = false)
}
