package com.search;


import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;

import java.io.IOException;
import java.net.InetAddress;

/**
 * Created by hong on 2017-07-24.
 */
public class TransportClients {

    TransportClient client;

    public TransportClient mkClient() throws IOException {

        return client = new PreBuiltTransportClient(Settings.EMPTY)
                .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("http://localhost"), 9300));

    }

    public void closeConnection() {
        client.close();
    }

    public TransportClient getClient() {
        return client;
    }



}
