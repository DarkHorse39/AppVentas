package gt.edu.umg.AppVentas.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    // ¡OJO AQUÍ! Usamos 10.0.2.2 porque es la IP especial del emulador para llegar a tu PC.
    // Si usas un celular físico, cambia esto por la IP de tu PC (ej. http://192.168.1.15:8080/)
    private static final String BASE_URL = "http://127.0.0.1:8080/";
    private static Retrofit retrofit = null;

    public static Retrofit getClient() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}