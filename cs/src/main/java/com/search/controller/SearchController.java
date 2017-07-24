package com.search.controller;

import com.search.TransportClients;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Date;

import static org.elasticsearch.common.xcontent.XContentFactory.jsonBuilder;

/**
 * Created by hong on 2017-07-24.
 */
@RestController
@RequestMapping(value = "/search")
public class SearchController {

    TransportClient client;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public void init() throws IOException {

        client = new TransportClients().mkClient();


    }

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public void index() throws IOException {

        IndexResponse response = client.prepareIndex("twitter", "tweet", "1")
                .setSource(jsonBuilder()
                        .startObject()
                        .field("user", "kimchy")
                        .field("postDate", new Date())
                        .field("message", "trying out Elasticsearch")
                        .endObject()
                )
                .get();

        System.out.println(response);

    }
}
