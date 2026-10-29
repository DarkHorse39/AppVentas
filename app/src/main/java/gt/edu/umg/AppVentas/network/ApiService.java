package gt.edu.umg.AppVentas.network;

import gt.edu.umg.AppVentas.models.Factura;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiService {
    @POST("api/facturas")
    Call<Factura> registrarFactura(@Body Factura factura);
}