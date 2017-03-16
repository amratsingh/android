public class MainActivity extends AppCompatActivity {

    AbstractXMPPConnection conn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        MyLoginTask task = new MyLoginTask();
        task.execute("");
    }

    private class MyLoginTask extends AsyncTask<String, String, String> {
        @Override
        protected String doInBackground(String... params) {
            // Create a connection to the jabber.org server.
            XMPPTCPConnectionConfiguration config = XMPPTCPConnectionConfiguration.builder()
                    .setUsernameAndPassword("test", "test")
                    .setHost("192.168.42.154")
                    .setSecurityMode(ConnectionConfiguration.SecurityMode.disabled)
                    .setServiceName("localhost")
                    .setPort(5222)
                    .setDebuggerEnabled(true) // to view what's happening in detail
                    .build();

            conn1 = new XMPPTCPConnection(config);
            try {
                conn1.connect();
                if (conn1.isConnected()) {
                    Log.w("app", "conn done");
                }
                conn1.login();

                if (conn1.isAuthenticated()) {
                    Log.w("app", "Auth done");
                }


                if (conn1.isAuthenticated()) {
                    Log.w("app", "Auth done");
                    ChatManager chatManager = ChatManager.getInstanceFor(conn1);

                    chatManager.addChatListener(new ChatManagerListener() {
                        @Override
                        public void chatCreated(Chat chat, boolean createdLocally) {
                            chat.addMessageListener(new ChatMessageListener() {
                                @Override
                                public void processMessage(Chat chat, Message message) {
                                    System.out.println("Received message: " + (message != null ? message.getBody() : "NULL"));
                                }
                            });

                            Log.w("app", chat.toString());
                        }
                    });

                    Chat chat = chatManager.createChat("test2@sunny", new ChatMessageListener() {
                        @Override
                        public void processMessage(Chat chat, Message message) {

                            Log.d("Chat", "processMessage");
                            Log.d("message", "aa " + message.getBody());
                        }
                    });

                    chat.sendMessage("hello");

                }
            } catch (Exception e) {
                Log.w("app", e.toString());
            }

            return "";
        }

        @Override
        protected void onPostExecute(String result) {
        }
    }
}
