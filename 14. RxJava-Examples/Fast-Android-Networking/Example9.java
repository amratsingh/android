package com.rx.example;

//Fast Android Networking - RxAndroid
//Multiple Requests Combine (zip)

public class Example9 {
//
//    private Observable<List<User>> getCricketFansObservable() {
//        return Rx2AndroidNetworking.get("https://fierce-cove-29863.herokuapp.com/getAllCricketFans")
//                .build()
//                .getObjectListObservable(User.class);
//    }
//
//    private Observable<List<User>> getFootballFansObservable() {
//        return Rx2AndroidNetworking.get("https://fierce-cove-29863.herokuapp.com/getAllFootballFans")
//                .build()
//                .getObjectListObservable(User.class)
//                .doOnNext(new Consumer<List<User>>() {
//                    @Override
//                    public void accept(List<User> users) throws Exception {
//                        Log.d(TAG, "getFootballFansObservable Called");
//                    }
//                });
//    }
//
//    private void findUsersWhoLovesBoth() {
//
//        Observable.zip(getCricketFansObservable(), getFootballFansObservable(),
//                new BiFunction<List<User>, List<User>, List<User>>() {
//                    @Override
//                    public List<User> apply(List<User> cricketFans, List<User> footballFans) throws Exception {
//                        List<User> userWhoLovesBoth = merge(cricketFans, footballFans);
//                        return userWhoLovesBoth;
//                    }
//                })
//                .subscribeOn(Schedulers.newThread())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Observer<List<User>>() {
//                    @Override
//                    public void onSubscribe(Disposable d) {
//
//                    }
//
//                    @Override
//                    public void onNext(List<User> users) {
//                        // do anything with user who loves both
//                        Log.d(TAG, "userList size : " + users.size());
//                        for (User user : users) {
//                            Log.d(TAG, "id : " + user.id);
//                            Log.d(TAG, "firstname : " + user.firstname);
//                            Log.d(TAG, "lastname : " + user.lastname);
//                        }
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
////                        Utils.logError(TAG, e);
//                    }
//
//                    @Override
//                    public void onComplete() {
//                        Log.d(TAG, "onComplete");
//                    }
//                });
//    }
//
//    public List<User> merge(List<User> cricketFans, List<User> footballFans) {
//        cricketFans.addAll(footballFans);
//        return cricketFans;
//    }
}
