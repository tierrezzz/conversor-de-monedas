public class ConversorMoneda {
    private APIService apiService;

    public ConversorMoneda() {
        this.apiService = new APIService();
    }

    public double convertir(Moneda from, Moneda to, double cantidad) throws Exception {
        double tasa = apiService.obtenerTasa(from.getCodigo(), to.getCodigo());
        return cantidad * tasa;
    }
}
