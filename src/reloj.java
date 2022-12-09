public class reloj extends Thread{
    protected int _horas;
    protected int _minutos;
    protected int _segundos;
    protected boolean mostrar = true;
    protected boolean estado = true;

    public reloj(int horas, int minutos, int segundos) {
        this._horas = horas;
        this._minutos = minutos;
        this._segundos = segundos;
    }

    public void run() {
        while (estado) {
            try {
                Thread.sleep(1000);
                _segundos++;
                if (_segundos == 60) {
                    _segundos = 0;
                    _minutos++;
                    if (_minutos == 60) {
                        _minutos = 0;
                        _horas++;
                        if (_horas == 24) {
                            _horas = 0;
                        }
                    }
                }
                if (mostrar) {
                    System.out.print("\r" + getHora());
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public String getHora() {
        return (this._horas < 10 ? "0" : "") + this._horas + ":" +
            (this._minutos < 10 ? "0" : "") + this._minutos + ":" +
            (this._segundos < 10 ? "0" : "") + this._segundos;
    }
}
