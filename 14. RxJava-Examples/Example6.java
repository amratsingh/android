package com.rx.example;

//    Action One after one

public class Example6 {

//        myObservable = Observable.create(new Observable.OnSubscribe<String>() {
//            @Override
//            public void call(Subscriber<? super String> subscriber) {
//                try {
//
//                    for (int i = 0; i < 20000; i++) {
//                        Log.e("loop", i + "<<");
//                    }
//
//                    subscriber.onNext("Data"); // Emit the contents of the URL
//                    subscriber.onCompleted(); // Nothing more to emit
//                } catch (Exception e) {
//                    subscriber.onError(e); // In case there are network errors
//                }
//            }
//        });
//
//        myObservable2 = Observable.create(new Observable.OnSubscribe<String>() {
//            @Override
//            public void call(Subscriber<? super String> subscriber) {
//                try {
//
//
//                    for (int i = 0; i < 20000; i++) {
//                        Log.e("loop2", i + "<<");
//                    }
//
//                    subscriber.onNext("Data2"); // Emit the contents of the URL
//                    subscriber.onCompleted(); // Nothing more to emit
//                } catch (Exception e) {
//                    subscriber.onError(e); // In case there are network errors
//                }
//            }
//        });


//        myObservable = myObservable
//                .subscribeOn(Schedulers.newThread()) // Create a new Thread
//                .observeOn(AndroidSchedulers.mainThread());
//
//        myObservable2 = myObservable2
//                .subscribeOn(Schedulers.newThread()) // Create a new Thread
//                .observeOn(AndroidSchedulers.mainThread());


//            Observable<String> concatenated = Observable.concat(myObservable, myObservable2);


//            Subscription mySubscription2 = concatenated.subscribe(myAction);
}
