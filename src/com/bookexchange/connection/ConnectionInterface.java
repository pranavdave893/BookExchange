package com.bookexchange.connection;

import java.sql.Connection;

public interface ConnectionInterface
{
	public Connection connect();
	public void close(Connection c);
}
