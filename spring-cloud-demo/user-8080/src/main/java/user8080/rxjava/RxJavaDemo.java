package user8080.rxjava;

import com.alibaba.excel.EasyExcel;
import rx.Observable;
import rx.Observer;
import rx.functions.Action;
import rx.functions.Action0;

public class RxJavaDemo {
    public static void main(String[] args) {
        String[] data = new String[]{"加载","验证","初始化"};

        Action0 action0 = new Action0() {
            @Override
            public void call() {
                System.out.println("action: on completed");
            }
        };

        Observable<String> observable = Observable.defer(()->{
            Observable<String> observable1 = Observable.from(data);
            return observable1.doOnCompleted(action0);
        });
        Observer observer = new Observer() {
            @Override
            public void onCompleted() {
                System.out.println("observer: on Completed");
            }

            @Override
            public void onError(Throwable throwable) {
                System.out.println("observer: error");
            }

            @Override
            public void onNext(Object o) {
                System.out.println("observer:　"+o.toString());
            }
        };
        observable.subscribe(observer);

    }
}
