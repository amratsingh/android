package com.rx.example;

//    Action on Different Thread

public class Example4 {


//        myObservable = Observable.create(new Observable.OnSubscribe<String>() {
//            @Override
//            public void call(Subscriber<? super String> subscriber) {
//                try {
//
//                    for (int i = 0; i < 10000; i++) {
//                        Log.d("loop", i + "<<");
//                    }
//
////                    String data = fetchData("http://www.google.com");
//                    subscriber.onNext("Data"); // Emit the contents of the URL
//                    subscriber.onCompleted(); // Nothing more to emit
//                } catch (Exception e) {
//                    subscriber.onError(e); // In case there are network errors
//                }
//            }
//        });

//        myAction = new Action1<String>() {
//            @Override
//            public void call(String s) {
//
//                tvText.setText(s);
//
////                Toast.makeText(MainActivity.this, "Received Action: " + s, Toast.LENGTH_SHORT).show();
////                Log.d("Received Action: ", s);
//            }
//        };

//        myObservable = myObservable
//                .subscribeOn(Schedulers.newThread()) // Create a new Thread
//                .observeOn(AndroidSchedulers.mainThread());

//            Subscription mySubscription = myObservable.subscribe(myAction);
}