package com.solvd.insurancecompany.connectionpool;

import com.solvd.insurancecompany.filereader.CustomFileReader;
import com.solvd.insurancecompany.threads.CustomThread;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class ConnectionPool {
    private static final Logger LOGGER = LogManager.getLogger(ConnectionPool.class);
    private List<CustomThread> availableConnections = new ArrayList<>();
    private List<CustomThread> usedConnections = new ArrayList<>();
    private final static int CONNECTION_POOL_SIZE = 1;

    public ConnectionPool(String fileName) {
        for (int i = 0; i < CONNECTION_POOL_SIZE; i++) {
            availableConnections.add(new CustomThread(fileName));
        }
    }

    public CustomThread getConnection() {
        if (availableConnections.size() == 0) {
            LOGGER.info("No any available connection, Try connect later.");
            return null;
        } else {
            CustomThread connection =
                    availableConnections.remove(
                            availableConnections.size() - 1);
            usedConnections.add(connection);
            return connection;
        }
    }

    public boolean releaseConnection(CustomThread connection) {
        if (null != connection) {
            usedConnections.remove(connection);
            availableConnections.add(connection);
            return true;
        }
        return false;
    }
}

