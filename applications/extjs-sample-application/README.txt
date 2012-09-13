// GlassFish configuration commands
./bin/asadmin create-jdbc-connection-pool \
              --restype javax.sql.DataSource \
              --datasourceclassname org.apache.derby.jdbc.EmbeddedDataSource \
              --property NetworkProtocol=jdbc\\:derby\\:memory:DatabaseName=task-manager:ConnectionAttributes=create\\=true \
              TaskManagerPool
./bin/asadmin create-jdbc-resource \
              --connectionpoolid TaskManagerPool \
              jdbc/taskManager

// Final GlassFish configuration
 <jdbc-connection-pool datasource-classname="org.apache.derby.jdbc.EmbeddedDataSource" res-type="javax.sql.DataSource" name="TaskManagerPool">
	<property name="NetworkProtocol" value="jdbc:derby:memory"></property>
	<property name="DatabaseName" value="task-manager"></property>
	<property name="ConnectionAttributes" value="create=true"></property>
</jdbc-connection-pool>
<jdbc-resource pool-name="TaskManagerPool" description="" jndi-name="jdbc/taskManager"></jdbc-resource>
