package icoder.retrofit.uz.api.service;

import android.util.Log;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    private static final String BASE_URL = "https://developers.zomato.com/api/v2.1/";
    private static final String USER_KEY = "664b69e5c188bf6d52a64356afd3fe46";
    private static Retrofit retrofit = null;

    public static Retrofit getClient() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(getHeader(USER_KEY))
                    .build();
        }
        return retrofit;
    }

    private static OkHttpClient getHeader(final String header1) {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okClient = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .addNetworkInterceptor(
                        new Interceptor() {
                            @Override
                            public Response intercept(Interceptor.Chain chain) throws IOException {
                                Request request = null;
                                if (header1 != null) {
                                    Log.d("--USER_KEY-- ", header1);

                                    Request original = chain.request();
                                    // Request customization: add request headers
                                    Request.Builder requestBuilder = original.newBuilder()
                                            .addHeader("user-key", header1);

                                    request = requestBuilder.build();
                                }
                                return chain.proceed(request);
                            }
                        })
                .build();
        return okClient;

    }
}
