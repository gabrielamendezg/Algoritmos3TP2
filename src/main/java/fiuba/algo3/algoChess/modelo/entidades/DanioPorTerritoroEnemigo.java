package fiuba.algo3.algoChess.modelo.entidades;

import fiuba.algo3.algoChess.modelo.Observador;
import fiuba.algo3.algoChess.modelo.tablero.Posicion;

public class DanioPorTerritoroEnemigo  {
    private final TipoUnidad unidadTipo;
    private int danioExtra = 0;

    public DanioPorTerritoroEnemigo(TipoUnidad tipo) {
        unidadTipo = tipo;
    }

    public void actualizaDanioPorTerritoroEnemigo(Posicion posicion) {
        if (unidadTipo instanceof UnidadA) {
            if (posicion.getX() > 10) {
                danioExtra = 5;
            }
            return;
        }

        if (unidadTipo instanceof UnidadB) {
            if (posicion.getX() < 11) {
                danioExtra = 5;
            }
            return;
        }
    }

    public int penalizacionPorTerritoriEnemigo(int daño) {
        //return ((danioExtra * daño) / 100 );
        if(danioExtra > 0) return 5;
        return 0;
    }
}
