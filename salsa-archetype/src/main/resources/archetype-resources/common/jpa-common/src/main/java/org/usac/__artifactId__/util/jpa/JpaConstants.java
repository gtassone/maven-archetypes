package org.usac.${artifactId}.util.jpa;

public class JpaConstants {

	public static final String JDBC_DRIVER = "javax.persistence.jdbc.driver";
	
	public static final String JDBC_URL = "javax.persistence.jdbc.url";

	public static final String JDBC_USER = "javax.persistence.jdbc.user";

	public static final String JDBC_PASSWORD = "javax.persistence.jdbc.password";

	
    /**
     * The "javax.persistence.schema-generation.database.action" property specifies the action to be taken by the
     * persistence provider with regard to the database artifacts. The values for this property are "none", "create",
     * "drop-and-create", "drop". If the "javax.persistence.schema-generation.database.action" property is not
     * specified, no schema generation actions must be taken on the database.
     */
    public static final String SCHEMA_GENERATION_DATABASE_ACTION =
            "javax.persistence.schema-generation.database.action";

    /**
     * The "javax.persistence.schema-generation.scripts.action" property specifies which scripts are to be generated by
     * the persistence provider. The values for this property are "none", "create", "drop-and-create", "drop". Scripts
     * will only be generated if script targets are specified. If this property is not specified, no scripts will be
     * generated.
     */
    public static final String SCHEMA_GENERATION_SCRIPTS_ACTION = "javax.persistence.schema-generation.scripts.action";

    /**
     * The "javax.persistence.schema-generation.create-source" property specifies whether the creation of database
     * artifacts is to occur on the basis of the object/relational mapping metadata, DDL script, or a combination of the
     * two. The values for this property are "metadata", "script", "metadata-then-script", "script-then-metadata". If
     * this property is not specified, and a script is specified by the
     * "javax.persistence.schema-generation.create-script-source property", the script (only) will be used for schema
     * generation; otherwise if this property is not specified, schema generation will occur on the basis of the
     * object/relational mapping metadata (only). The "metadata-then-script" and "script-then-metadata" values specify
     * that a combination of metadata and script is to be used and the order in which this use is to occur. If either of
     * these values is specified and the resulting database actions are not disjoint, the results are undefined and
     * schema generation may fail.
     */
    public static final String SCHEMA_GENERATION_CREATE_SOURCE = "javax.persistence.schema-generation.create-source";

    /**
     * The "javax.persistence.schema-generation.drop-source" property specifies whether the dropping of database
     * artifacts is to occur on the basis of the object/relational mapping metadata, DDL script, or a combination of the
     * two. The values for this property are "metadata", "script", "metadata-then-script", "script-then-metadata". If
     * this property is not specified, and a script is specified by the
     * "javax.persistence.schema-generation.drop-script-source" property, the script (only) will be used for the
     * dropping of database artifacts; otherwise if this property is not specified, the dropping of database artifacts
     * will occur on the basis of the object/relational mapping metadata (only). The "metadata-then-script" and
     * "script-then-metadata" values specify that a combination of metadata and script is to be used and the order in
     * which this use is to occur. If either of these values is specified and the resulting database actions are not
     * disjoint, the results are undefined and the dropping of database artifacts may fail.
     */
    public static final String SCHEMA_GENERATION_DROP_SOURCE = "javax.persistence.schema-generation.drop-source";

    /**
     * In Java EE environments, it is anticipated that the Java EE platform provider may wish to control the creation of
     * database schemas rather than delegate this task to the persistence provider. The
     * "javax.persistence.schema-generation.create-database-schemas" property specifies whether the persistence provider
     * is to create the database schema(s) in addition to creating database objects such as tables, sequences,
     * constraints, etc. The value of this boolean property should be set to true if the persistence provider is to
     * create schemas in the database or to generate DDL that contains "CREATE SCHEMA" commands. If this property is not
     * supplied, the provider should not attempt to create database schemas. This property may also be specified in Java
     * SE environments.
     */
    public static final String SCHEMA_GENERATION_CREATE_DATABASE_SCHEMAS =
            "javax.persistence.schema-generation.create-database-schemas";

    /**
     * If scripts are to be generated, the target locations for the writing of these scripts must be specified. The
     * "javax.persistence.schema-generation.scripts.create-target" property specifies a java.IO.Writer configured for
     * use by the persistence provider for output of the DDL script or a string specifying the file URL for the DDL
     * script. This property should only be specified if scripts are to be generated.
     */
    public static final String SCHEMA_GENERATION_SCRIPTS_CREATE_TARGET =
            "javax.persistence.schema-generation.scripts.create-target";

    /**
     * If scripts are to be generated, the target locations for the writing of these scripts must be specified. The
     * "javax.persistence.schema-generation.scripts.drop-target" property specifies a java.IO.Writer configured for use
     * by the persistence provider for output of the DDL script or a string specifying the file URL for the DDL script.
     * This property should only be specified if scripts are to be generated.
     */
    public static final String SCHEMA_GENERATION_SCRIPTS_DROP_TARGET =
            "javax.persistence.schema-generation.scripts.drop-target";

    /**
     * If scripts are to be generated by the persistence provider and a connection to the target database is not
     * supplied, the "javax.persistence.database-product-name" property must be specified. The value of this property
     * should be the value returned for the target database by the JDBC DatabaseMetaData method getDatabaseProductName.
     * If sufficient database version information is not included in the result of this method, the
     * "javax.persistence.database-major-version" and "javax.persistence.database-minor-version" properties should be
     * specified as needed. These should contain the values returned by the JDBC getDatabaseMajorVersion and
     * getDatabaseMinor-Version methods respectively.
     */
    public static final String SCHEMA_DATABASE_PRODUCT_NAME = "javax.persistence.database-product-name";

    /**
     * If sufficient database version information is not included from the JDBC DatabaseMetaData method
     * getDatabaseProductName, the "javax.persistence.database-major-version" property should be specified as needed.
     * This should contain the value returned by the JDBC getDatabaseMajor-Version method.
     */
    public static final String SCHEMA_DATABASE_MAJOR_VERSION = "javax.persistence.database-major-version";

    /**
     * If sufficient database version information is not included from the JDBC DatabaseMetaData method
     * getDatabaseProductName, the "javax.persistence.database-minor-version" property should be specified as needed.
     * This should contain the value returned by the JDBC getDatabaseMinor-Version method.
     */
    public static final String SCHEMA_DATABASE_MINOR_VERSION = "javax.persistence.database-minor-version";

    /**
     * The "javax.persistence.schema-generation.create-script-source" is used for script execution. In Java EE container
     * environments, it is generally expected that the container will be responsible for executing DDL scripts, although
     * the container is permitted to delegate this task to the persistence provider. If DDL scripts are to be used in
     * Java SE environments or if the Java EE container delegates the execution of scripts to the persistence provider,
     * this property must be specified. The "javax.persistence.schema-generation.create-script-source" property
     * specifies a java.IO.Reader configured for reading of the DDL script or a string designating a file URL for the
     * DDL script.
     */
    public static final String SCHEMA_GENERATION_CREATE_SCRIPT_SOURCE =
            "javax.persistence.schema-generation.create-script-source";

    /**
     * The "javax.persistence.schema-generation.drop-script-source" is used for script execution. In Java EE container
     * environments, it is generally expected that the container will be responsible for executing DDL scripts, although
     * the container is permitted to delegate this task to the persistence provider. If DDL scripts are to be used in
     * Java SE environments or if the Java EE container delegates the execution of scripts to the persistence provider,
     * this property must be specified. The "javax.persistence.schema-generation.drop-script-source" property specifies
     * a java.IO.Reader configured for reading of the DDL script or a string designating a file URL for the DDL script.
     */
    public static final String SCHEMA_GENERATION_DROP_SCRIPT_SOURCE =
            "javax.persistence.schema-generation.drop-script-source";

    /**
     * The "javax.persistence.schema-generation.connection" property specifies the JDBC connection to be used for schema
     * generation. This is intended for use in Java EE environments, where the platform provider may want to control the
     * database privileges that are available to the persistence provider. This connection is provided by the container,
     * and should be closed by the container when the schema generation request or entity manager factory creation
     * completes. The connection provided must have credentials sufficient for the persistence provider to carry out the
     * requested actions. If this property is not specified, the persistence provider should use the DataSource that has
     * otherwise been provided.
     */
    public static final String SCHEMA_GENERATION_CONNECTION = "javax.persistence.schema-generation.connection";

    /**
     * In Java EE container environments, it is generally expected that the container will be responsible for executing
     * data load scripts, although the container is permitted to delegate this task to the persistence provider. If a
     * load script is to be used in Java SE environments or if the Java EE container delegates the execution of the load
     * script to the persistence provider, this property must be specified. The
     * "javax.persistence.sql-load-script-source" property specifies a java.IO.Reader configured for reading of the SQL
     * load script for database initialization or a string designating a file URL for the script.
     */
    public static final String SCHEMA_GENERATION_SQL_LOAD_SCRIPT_SOURCE = "javax.persistence.sql-load-script-source";

    /**
     * The parameter value "create" For use with the "javax.persistence.schema-generation.database.action" and
     * "javax.persistence.schema-generation.scripts.action" properties. Specifies that database tables should be
     * created.
     */
    public static final String SCHEMA_GENERATION_CREATE_ACTION = "create";

    /**
     * The parameter value "drop-and-create" For use with the "javax.persistence.schema-generation.database.action" and
     * "javax.persistence.schema-generation.scripts.action" properties. Specifies that database tables should be
     * dropped, then created.
     */
    public static final String SCHEMA_GENERATION_DROP_AND_CREATE_ACTION = "drop-and-create";

    /**
     * The parameter value "drop" For use with the "javax.persistence.schema-generation.database.action" and
     * "javax.persistence.schema-generation.scripts.action" properties. Specifies that database tables should be
     * dropped.
     */
    public static final String SCHEMA_GENERATION_DROP_ACTION = "drop";

    /**
     * The parameter value "none" For use with the "javax.persistence.schema-generation.database.action" and
     * "javax.persistence.schema-generation.scripts.action" properties. Specifies that database tables should not be
     * created or dropped.
     */
    public static final String SCHEMA_GENERATION_NONE_ACTION = "none";

    /**
     * The parameter value "metadata" For use with the "javax.persistence.schema-generation.create-source" and
     * "javax.persistence.schema-generation.drop-source" properties. Specifies that DDL generation source will come from
     * the metadata only.
     */
    public static final String SCHEMA_GENERATION_METADATA_SOURCE = "metadata";

    /**
     * The parameter value "script" For use with the "javax.persistence.schema-generation.create-source" and
     * "javax.persistence.schema-generation.drop-source" properties. Specifies that DDL generation source will come from
     * scripts only.
     */
    public static final String SCHEMA_GENERATION_SCRIPT_SOURCE = "script";

    /**
     * The parameter value "metadata-then-script" For use with the "javax.persistence.schema-generation.create-source"
     * and "javax.persistence.schema-generation.drop-source" properties. Specifies that DDL generation source will come
     * from the metadata first followed with the scripts.
     */
    public static final String SCHEMA_GENERATION_METADATA_THEN_SCRIPT_SOURCE = "metadata-then-script";

    /**
     * The parameter value "script-then-metadata" For use with the "javax.persistence.schema-generation.create-source"
     * and "javax.persistence.schema-generation.drop-source" properties. Specifies that DDL generation source will come
     * from the scripts first followed with the metadata.
     */
    public static final String SCHEMA_GENERATION_SCRIPT_THEN_METADATA_SOURCE = "script-then-metadata";

}
