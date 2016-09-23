package com.example;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

/**
 * Created by bearden-tellez on 9/23/16.
 */
public class SendMessageTests {
    @BeforeClass
    public static void setUp() throws Exception {
        Server myServer = new Server();
        myServer.StartServer();


    }

    @AfterClass
    public static void tearDown() throws Exception {

    }

    @Test
    public void testSingleMessageToServer() throws IOException {
        String testClientMessage = "testClientMessage";
        String testServerMessage;


        WebChatClient  myWebChatClient= new WebChatClient();

        String serverResponse = myWebChatClient.SendMessage(testClientMessage);

        assertEquals("Message received: " + testClientMessage, serverResponse);

    }
}