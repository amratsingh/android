
    private long back_pressed;
    private static final int TIME_DELAY = 2000;

    @Override
    public void onBackPressed() {

        if (back_pressed + TIME_DELAY > System.currentTimeMillis()) {
            super.onBackPressed();
        } else {
            Toast.makeText(getBaseContext(), "Press once again to exit", Toast.LENGTH_SHORT).show();
        }

        back_pressed = System.currentTimeMillis();
    }
