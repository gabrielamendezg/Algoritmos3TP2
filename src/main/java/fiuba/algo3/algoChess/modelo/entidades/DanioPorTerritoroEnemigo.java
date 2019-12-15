package fiuba.algo3.algoChess.modelo.entidades;

import fiuba.algo3.algoChess.modelo.tablero.Posicion;

public class DanioPorTerritoroEnemigo  {
    private final TipoUnidad unidadTipo;
    private double danioExtra = 0;

    public DanioPorTerritoroEnemigo(TipoUnidad tipo) {
        unidadTipo = tipo;
    }

    public void actualizaDanioPorTerritoroEnemigo(Posicion posicion) {
        if (unidadTipo instanceof UnidadA) {
            if (posicion.getX() > 10) {
                danioExtra = 0.05;
            }
            return;
        }

        if (unidadTipo instanceof UnidadB) {
            if (posicion.getX() < 11) {
                danioExtra = 0.05;
            }
            return;
        }
    }

    public double penalizacionPorTerritorioEnemigo(double danio) {
        if(danioExtra > 0) return (danioExtra * danio);
        return 0;
    }
}
