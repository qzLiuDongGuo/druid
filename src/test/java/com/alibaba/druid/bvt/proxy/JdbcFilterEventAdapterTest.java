package com.alibaba.druid.bvt.proxy;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import junit.framework.Assert;
import junit.framework.TestCase;

import com.alibaba.druid.filter.FilterChain;
import com.alibaba.druid.filter.FilterChainImpl;
import com.alibaba.druid.filter.FilterEventAdapter;
import com.alibaba.druid.proxy.jdbc.ConnectionProxy;
import com.alibaba.druid.proxy.jdbc.ConnectionProxyImpl;
import com.alibaba.druid.proxy.jdbc.DataSourceProxy;
import com.alibaba.druid.proxy.jdbc.DataSourceProxyConfig;
import com.alibaba.druid.proxy.jdbc.DataSourceProxyImpl;
import com.alibaba.druid.proxy.jdbc.PreparedStatementProxy;
import com.alibaba.druid.proxy.jdbc.PreparedStatementProxyImpl;
import com.alibaba.druid.proxy.jdbc.ResultSetProxy;
import com.alibaba.druid.proxy.jdbc.ResultSetProxyImpl;
import com.alibaba.druid.proxy.jdbc.StatementProxy;

public class JdbcFilterEventAdapterTest extends TestCase {
	public void test_filterEventAdapter() throws Exception {
		DataSourceProxyConfig config = new DataSourceProxyConfig();
		DataSourceProxy dataSource = new DataSourceProxyImpl(null, config);

		FilterEventAdapter filter = new FilterEventAdapter(){};

		String sql = "SELECT * FROM PATROL";
		ConnectionProxy connection = new ConnectionProxyImpl(dataSource, null, new Properties(), 1001);
		final PreparedStatementProxy statement = new PreparedStatementProxyImpl(connection, null, sql, 1002);

		{
			FilterChain chain = new FilterChainImpl(new DataSourceProxyImpl(null, config)) {
				public boolean statement_execute(StatementProxy statement, String sql) throws SQLException {
					throw new SQLException();
				}
			};

			Throwable error = null;
			try {
				filter.statement_execute(chain, statement, sql);
			} catch (Throwable ex) {
				error = ex;
			}
			Assert.assertNotNull(error);
		}

		{
			FilterChain chain = new FilterChainImpl(new DataSourceProxyImpl(null, config)) {
				public boolean statement_execute(StatementProxy statement, String sql) throws SQLException {
					throw new RuntimeException();
				}
			};

			Throwable error = null;
			try {
				filter.statement_execute(chain, statement, sql);
			} catch (Throwable ex) {
				error = ex;
			}
			Assert.assertNotNull(error);
		}

		{
			FilterChain chain = new FilterChainImpl(new DataSourceProxyImpl(null, config)) {
				public boolean statement_execute(StatementProxy statement, String sql) throws SQLException {
					throw new Error();
				}
			};

			Throwable error = null;
			try {
				filter.statement_execute(chain, statement, sql);
			} catch (Throwable ex) {
				error = ex;
			}
			Assert.assertNotNull(error);
		}

		// //////////////////////////

		{
			FilterChain chain = new FilterChainImpl(new DataSourceProxyImpl(null, config)) {
				public boolean statement_execute(StatementProxy statement, String sql, int autoGeneratedKeys) throws SQLException {
					throw new SQLException();
				}
			};

			Throwable error = null;
			try {
				filter.statement_execute(chain, statement, sql, Statement.NO_GENERATED_KEYS);
			} catch (Throwable ex) {
				error = ex;
			}
			Assert.assertNotNull(error);
		}

		{
			FilterChain chain = new FilterChainImpl(new DataSourceProxyImpl(null, config)) {
				public boolean statement_execute(StatementProxy statement, String sql, int autoGeneratedKeys) throws SQLException {
					throw new RuntimeException();
				}
			};

			Throwable error = null;
			try {
				filter.statement_execute(chain, statement, sql, Statement.NO_GENERATED_KEYS);
			} catch (Throwable ex) {
				error = ex;
			}
			Assert.assertNotNull(error);
		}

		{
			FilterChain chain = new FilterChainImpl(new DataSourceProxyImpl(null, config)) {
				public boolean statement_execute(StatementProxy statement, String sql, int autoGeneratedKeys) throws SQLException {
					throw new Error();
				}
			};

			Throwable error = null;
			try {
				filter.statement_execute(chain, statement, sql, Statement.NO_GENERATED_KEYS);
			} catch (Throwable ex) {
				error = ex;
			}
			Assert.assertNotNull(error);
		}

		// //////////////////////////

		{
			FilterChain chain = new FilterChainImpl(new DataSourceProxyImpl(null, config)) {
				public boolean statement_execute(StatementProxy statement, String sql, int columnIndexes[]) throws SQLException {
					throw new SQLException();
				}
			};

			Throwable error = null;
			try {
				filter.statement_execute(chain, statement, sql, new int[0]);
			} catch (Throwable ex) {
				error = ex;
			}
			Assert.assertNotNull(error);
		}

		{
			FilterChain chain = new FilterChainImpl(new DataSourceProxyImpl(null, config)) {
				public boolean statement_execute(StatementProxy statement, String sql, int columnIndexes[]) throws SQLException {
					throw new RuntimeException();
				}
			};

			Throwable error = null;
			try {
				filter.statement_execute(chain, statement, sql, new int[0]);
			} catch (Throwable ex) {
				error = ex;
			}
			Assert.assertNotNull(error);
		}

		{
			FilterChain chain = new FilterChainImpl(new DataSourceProxyImpl(null, config)) {
				public boolean statement_execute(StatementProxy statement, String sql, int columnIndexes[]) throws SQLException {
					throw new Error();
				}
			};

			Throwable error = null;
			try {
				filter.statement_execute(chain, statement, sql, new int[0]);
			} catch (Throwable ex) {
				error = ex;
			}
			Assert.assertNotNull(error);
		}

		// //////////////////////////

		{
			FilterChain chain = new FilterChainImpl(new DataSourceProxyImpl(null, config)) {
				public boolean statement_execute(StatementProxy statement, String sql, String columnNames[]) throws SQLException {
					throw new SQLException();
				}
			};

			Throwable error = null;
			try {
				filter.statement_execute(chain, statement, sql, new String[0]);
			} catch (Throwable ex) {
				error = ex;
			}
			Assert.assertNotNull(error);
		}

		{
			FilterChain chain = new FilterChainImpl(new DataSourceProxyImpl(null, config)) {
				public boolean statement_execute(StatementProxy statement, String sql, String columnNames[]) throws SQLException {
					throw new RuntimeException();
				}
			};

			Throwable error = null;
			try {
				filter.statement_execute(chain, statement, sql, new String[0]);
			} catch (Throwable ex) {
				error = ex;
			}
			Assert.assertNotNull(error);
		}

		{
			FilterChain chain = new FilterChainImpl(new DataSourceProxyImpl(null, config)) {
				public boolean statement_execute(StatementProxy statement, String sql, String columnNames[]) throws SQLException {
					throw new Error();
				}
			};

			Throwable error = null;
			try {
				filter.statement_execute(chain, statement, sql, new String[0]);
			} catch (Throwable ex) {
				error = ex;
			}
			Assert.assertNotNull(error);
		}

		// //////////////////////////

		{
			FilterChain chain = new FilterChainImpl(new DataSourceProxyImpl(null, config)) {
				public int[] statement_executeBatch(StatementProxy statement) throws SQLException {
					throw new SQLException();
				}
			};

			Throwable error = null;
			try {
				filter.statement_executeBatch(chain, statement);
			} catch (Throwable ex) {
				error = ex;
			}
			Assert.assertNotNull(error);
		}

		{
			FilterChain chain = new FilterChainImpl(new DataSourceProxyImpl(null, config)) {
				public int[] statement_executeBatch(StatementProxy statement) throws SQLException {
					throw new RuntimeException();
				}
			};

			Throwable error = null;
			try {
				filter.statement_executeBatch(chain, statement);
			} catch (Throwable ex) {
				error = ex;
			}
			Assert.assertNotNull(error);
		}

		{
			FilterChain chain = new FilterChainImpl(new DataSourceProxyImpl(null, config)) {
				public int[] statement_executeBatch(StatementProxy statement) throws SQLException {
					throw new Error();
				}
			};

			Throwable error = null;
			try {
				filter.statement_executeBatch(chain, statement);
			} catch (Throwable ex) {
				error = ex;
			}
			Assert.assertNotNull(error);
		}

		// //////////////////////////

		{
			FilterChain chain = new FilterChainImpl(new DataSourceProxyImpl(null, config)) {
				public ResultSetProxy statement_executeQuery(StatementProxy statement, String sql) throws SQLException {
					throw new SQLException();
				}
			};

			Throwable error = null;
			try {
				filter.statement_executeQuery(chain, statement, sql);
			} catch (Throwable ex) {
				error = ex;
			}
			Assert.assertNotNull(error);
		}

		{
			FilterChain chain = new FilterChainImpl(new DataSourceProxyImpl(null, config)) {
				public ResultSetProxy statement_executeQuery(StatementProxy statement, String sql) throws SQLException {
					throw new RuntimeException();
				}
			};

			Throwable error = null;
			try {
				filter.statement_executeQuery(chain, statement, sql);
			} catch (Throwable ex) {
				error = ex;
			}
			Assert.assertNotNull(error);
		}

		{
			FilterChain chain = new FilterChainImpl(new DataSourceProxyImpl(null, config)) {
				public ResultSetProxy statement_executeQuery(StatementProxy statement, String sql) throws SQLException {
					throw new Error();
				}
			};

			Throwable error = null;
			try {
				filter.statement_executeQuery(chain, statement, sql);
			} catch (Throwable ex) {
				error = ex;
			}
			Assert.assertNotNull(error);
		}
		
		// //////////////////////////

		{
			FilterChain chain = new FilterChainImpl(new DataSourceProxyImpl(null, config)) {
				public int preparedStatement_executeUpdate(PreparedStatementProxy statement) throws SQLException {
					throw new SQLException();
				}
			};

			Throwable error = null;
			try {
				filter.preparedStatement_executeUpdate(chain, statement);
			} catch (SQLException ex) {
				error = ex;
			}
			Assert.assertNotNull(error);
		}

		{
			FilterChain chain = new FilterChainImpl(new DataSourceProxyImpl(null, config)) {
				public int preparedStatement_executeUpdate(PreparedStatementProxy statement) throws SQLException {
					throw new RuntimeException();
				}
			};

			Throwable error = null;
			try {
				filter.preparedStatement_executeUpdate(chain, statement);
			} catch (RuntimeException ex) {
				error = ex;
			}
			Assert.assertNotNull(error);
		}

		{
			FilterChain chain = new FilterChainImpl(new DataSourceProxyImpl(null, config)) {
				public int preparedStatement_executeUpdate(PreparedStatementProxy statement) throws SQLException {
					throw new Error();
				}
			};

			Throwable error = null;
			try {
				filter.preparedStatement_executeUpdate(chain, statement);
			} catch (Error ex) {
				error = ex;
			}
			Assert.assertNotNull(error);
		}

		// //////////////////////////
		

		// //////////////////////////

		{
			FilterChain chain = new FilterChainImpl(new DataSourceProxyImpl(null, config)) {
				public int statement_executeUpdate(StatementProxy statement, String sql) throws SQLException {
					throw new SQLException();
				}
			};

			Throwable error = null;
			try {
				filter.statement_executeUpdate(chain, statement, sql);
			} catch (SQLException ex) {
				error = ex;
			}
			Assert.assertNotNull(error);
		}

		{
			FilterChain chain = new FilterChainImpl(new DataSourceProxyImpl(null, config)) {
				public int statement_executeUpdate(StatementProxy statement, String sql) throws SQLException {
					throw new RuntimeException();
				}
			};

			Throwable error = null;
			try {
				filter.statement_executeUpdate(chain, statement, sql);
			} catch (RuntimeException ex) {
				error = ex;
			}
			Assert.assertNotNull(error);
		}

		{
			FilterChain chain = new FilterChainImpl(new DataSourceProxyImpl(null, config)) {
				public int statement_executeUpdate(StatementProxy statement, String sql) throws SQLException {
					throw new Error();
				}
			};

			Throwable error = null;
			try {
				filter.statement_executeUpdate(chain, statement, sql);
			} catch (Error ex) {
				error = ex;
			}
			Assert.assertNotNull(error);
		}

		// //////////////////////////

		{
			FilterChain chain = new FilterChainImpl(new DataSourceProxyImpl(null, config)) {
				public int statement_executeUpdate(StatementProxy statement, String sql, int autoGeneratedKeys) throws SQLException {
					throw new SQLException();
				}
			};

			Throwable error = null;
			try {
				filter.statement_executeUpdate(chain, statement, sql, Statement.NO_GENERATED_KEYS);
			} catch (SQLException ex) {
				error = ex;
			}
			Assert.assertNotNull(error);
		}

		{
			FilterChain chain = new FilterChainImpl(new DataSourceProxyImpl(null, config)) {
				public int statement_executeUpdate(StatementProxy statement, String sql, int autoGeneratedKeys) throws SQLException {
					throw new RuntimeException();
				}
			};

			Throwable error = null;
			try {
				filter.statement_executeUpdate(chain, statement, sql, Statement.NO_GENERATED_KEYS);
			} catch (RuntimeException ex) {
				error = ex;
			}
			Assert.assertNotNull(error);
		}

		{
			FilterChain chain = new FilterChainImpl(new DataSourceProxyImpl(null, config)) {
				public int statement_executeUpdate(StatementProxy statement, String sql, int autoGeneratedKeys) throws SQLException {
					throw new Error();
				}
			};

			Throwable error = null;
			try {
				filter.statement_executeUpdate(chain, statement, sql, Statement.NO_GENERATED_KEYS);
			} catch (Error ex) {
				error = ex;
			}
			Assert.assertNotNull(error);
		}

		// //////////////////////////

		{
			FilterChain chain = new FilterChainImpl(new DataSourceProxyImpl(null, config)) {
				public int statement_executeUpdate(StatementProxy statement, String sql, int columnIndexes[]) throws SQLException {
					throw new SQLException();
				}
			};

			Throwable error = null;
			try {
				filter.statement_executeUpdate(chain, statement, sql, new int[0]);
			} catch (Throwable ex) {
				error = ex;
			}
			Assert.assertNotNull(error);
		}

		{
			FilterChain chain = new FilterChainImpl(new DataSourceProxyImpl(null, config)) {
				public int statement_executeUpdate(StatementProxy statement, String sql, int columnIndexes[]) throws SQLException {
					throw new RuntimeException();
				}
			};

			Throwable error = null;
			try {
				filter.statement_executeUpdate(chain, statement, sql, new int[0]);
			} catch (Throwable ex) {
				error = ex;
			}
			Assert.assertNotNull(error);
		}

		{
			FilterChain chain = new FilterChainImpl(new DataSourceProxyImpl(null, config)) {
				public int statement_executeUpdate(StatementProxy statement, String sql, int columnIndexes[]) throws SQLException {
					throw new Error();
				}
			};

			Throwable error = null;
			try {
				filter.statement_executeUpdate(chain, statement, sql, new int[0]);
			} catch (Throwable ex) {
				error = ex;
			}
			Assert.assertNotNull(error);
		}

		// //////////////////////////

		{
			FilterChain chain = new FilterChainImpl(new DataSourceProxyImpl(null, config)) {
				public int statement_executeUpdate(StatementProxy statement, String sql, String columnNames[]) throws SQLException {
					throw new SQLException();
				}
			};

			Throwable error = null;
			try {
				filter.statement_executeUpdate(chain, statement, sql, new String[0]);
			} catch (Throwable ex) {
				error = ex;
			}
			Assert.assertNotNull(error);
		}

		{
			FilterChain chain = new FilterChainImpl(new DataSourceProxyImpl(null, config)) {
				public int statement_executeUpdate(StatementProxy statement, String sql, String columnNames[]) throws SQLException {
					throw new RuntimeException();
				}
			};

			Throwable error = null;
			try {
				filter.statement_executeUpdate(chain, statement, sql, new String[0]);
			} catch (Throwable ex) {
				error = ex;
			}
			Assert.assertNotNull(error);
		}

		{
			FilterChain chain = new FilterChainImpl(new DataSourceProxyImpl(null, config)) {
				public int statement_executeUpdate(StatementProxy statement, String sql, String columnNames[]) throws SQLException {
					throw new Error();
				}
			};

			Throwable error = null;
			try {
				filter.statement_executeUpdate(chain, statement, sql, new String[0]);
			} catch (Throwable ex) {
				error = ex;
			}
			Assert.assertNotNull(error);
		}
		
		/////////////////////////////
		
		{
			FilterChain chain = new FilterChainImpl(new DataSourceProxyImpl(null, config)) {
				public ResultSetProxy statement_getGeneratedKeys(StatementProxy statement) throws SQLException {
					return null;
				}
			};

			filter.statement_getGeneratedKeys(chain, statement);
		}
		
		{
			final ResultSetProxy resultSet = new ResultSetProxyImpl(statement, null, 2001, null);
			FilterChain chain = new FilterChainImpl(new DataSourceProxyImpl(null, config)) {
				public ResultSetProxy statement_getGeneratedKeys(StatementProxy statement) throws SQLException {
					return resultSet;
				}
			};
			
			filter.statement_getGeneratedKeys(chain, statement);
		}
		
		// //////////////////////////

		{
			FilterChain chain = new FilterChainImpl(new DataSourceProxyImpl(null, config)) {
				public boolean preparedStatement_execute(PreparedStatementProxy statement) throws SQLException {
					throw new SQLException();
				}
			};

			Throwable error = null;
			try {
				filter.preparedStatement_execute(chain, statement);
			} catch (SQLException ex) {
				error = ex;
			}
			Assert.assertNotNull(error);
		}

		{
			FilterChain chain = new FilterChainImpl(new DataSourceProxyImpl(null, config)) {
				public boolean preparedStatement_execute(PreparedStatementProxy statement) throws SQLException {
					throw new RuntimeException();
				}
			};

			Throwable error = null;
			try {
				filter.preparedStatement_execute(chain, statement);
			} catch (RuntimeException ex) {
				error = ex;
			}
			Assert.assertNotNull(error);
		}

		{
			FilterChain chain = new FilterChainImpl(new DataSourceProxyImpl(null, config)) {
				public boolean preparedStatement_execute(PreparedStatementProxy statement) throws SQLException {
					throw new Error();
				}
			};

			Throwable error = null;
			try {
				filter.preparedStatement_execute(chain, statement);
			} catch (Error ex) {
				error = ex;
			}
			Assert.assertNotNull(error);
		}
		
		// //////////////////////////

		{
			FilterChain chain = new FilterChainImpl(new DataSourceProxyImpl(null, config)) {
				public ResultSetProxy preparedStatement_executeQuery(PreparedStatementProxy statement) throws SQLException {
					throw new SQLException();
				}
			};

			Throwable error = null;
			try {
				filter.preparedStatement_executeQuery(chain, statement);
			} catch (SQLException ex) {
				error = ex;
			}
			Assert.assertNotNull(error);
		}

		{
			FilterChain chain = new FilterChainImpl(new DataSourceProxyImpl(null, config)) {
				public ResultSetProxy preparedStatement_executeQuery(PreparedStatementProxy statement) throws SQLException {
					throw new RuntimeException();
				}
			};

			Throwable error = null;
			try {
				filter.preparedStatement_executeQuery(chain, statement);
			} catch (RuntimeException ex) {
				error = ex;
			}
			Assert.assertNotNull(error);
		}

		{
			FilterChain chain = new FilterChainImpl(new DataSourceProxyImpl(null, config)) {
				public ResultSetProxy preparedStatement_executeQuery(PreparedStatementProxy statement) throws SQLException {
					throw new Error();
				}
			};

			Throwable error = null;
			try {
				filter.preparedStatement_executeQuery(chain, statement);
			} catch (Error ex) {
				error = ex;
			}
			Assert.assertNotNull(error);
		}
	}
}
