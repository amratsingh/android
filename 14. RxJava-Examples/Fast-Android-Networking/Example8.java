package com.rx.example;

//Fast Android Networking - RxAndroid
//Single Request

public class Example8 {

//    https://fierce-cove-29863.herokuapp.com/getAnUser/{userId}


//    public void getAllUser() {
//
//        Observable<User> observable = Rx2AndroidNetworking.get("https://fierce-cove-29863.herokuapp.com/getAllFriends/{userId}")
//                .addPathParameter("userId", "1")
//                .build()
//                .getObjectObservable(ApiUser.class)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .map(new Function<ApiUser, User>() {
//                    @Override
//                    public User apply(ApiUser apiUser) throws Exception {
//
//                        User user = new User(apiUser);
//                        return user;
//
//                    } // takes ApiUser and returns User
//
////                    @Override
////                    public User call(ApiUser apiUser) {
////                        // here we get ApiUser from server
////                        User user = new User(apiUser);
////                        // then by converting, we are returing user
////                        return user;
////                    }
//                }).subscribe(new Observer<User>() {
//                    @Override
//                    public void onSubscribe(Disposable d) {
//                    }
//
//                    @Override
//                    public void onNext(User users) {
//
////                        Log.d(TAG, "onResponse isMainThread : " + String.valueOf(Looper.myLooper() == Looper.getMainLooper()));
////                        Log.d(TAG, "userList size : " + users.size());
////                        for (User user : users) {
////                            Log.d(TAG, "===================================");
//                        Log.d(TAG, "id : " + users.id);
//                        Log.d(TAG, "firstname : " + users.firstname);
//                        Log.d(TAG, "lastname : " + users.lastname);
////                        }
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                    }
//
//                    @Override
//                    public void onComplete() {
//                    }
//                });
//    }
}
