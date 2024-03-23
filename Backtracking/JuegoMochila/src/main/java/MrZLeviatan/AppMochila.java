package MrZLeviatan;


/**
 * SE CREA EL EJECUTABLE APP
 */
public class AppMochila {

    public static void main(String[] args) {


        /**
         * SE CREA UNA LISTA DEL OBJETO "ELEMENTO" Y SE QUEMAN ALGUNOS DE ESTOS.
         */
        Elemento[] elementos = {

                new Elemento(1, 5),
                new Elemento(2, 2),
                new Elemento(4, 18),
                new Elemento(4, 30),
                new Elemento(10, 1),
                new Elemento(3,2),
                new Elemento(3, 10)
        };


        /**
         * SE CREAN DOS CLASES DE MOCHILA, SE USARAN PARA COMPARAR Y BUSCAR LA MAS OPTIMA.
         */

        Mochila base = new Mochila(elementos.length, 15);
        Mochila opt = new Mochila(elementos.length, 15);


        System.out.println("-- JUEGO DE LA MOCHILA --");
        llenarMochila(base, elementos, opt, false);
        System.out.println(opt);
    }


    /**
     * MÉTODO PARA LLENAR LA MOCHILA OPTIMA DESPUÉS DE COMPARAR LOS BENEFICIOS.
     */
    public static void llenarMochila(Mochila base, Elemento[] elementos, Mochila opt, boolean lleno) {

        if (lleno) {
            if (base.getBeneficios() > opt.getBeneficios()) {
                Elemento[] elementosMochBase = base.getElementos();
                opt.clear(0);
                comprobar(elementosMochBase, 0, opt);
            }
        }else{
            recorrer(base,elementos,opt,false,0);
        }
    }


    /**
     * MÉTODO QUE COMPRUEBA LAS MOCHILAS MAS SUS OPTIMIZACIONES
     */
    public static Mochila comprobar(Elemento[] elementoMoch, int i, Mochila opt) {

        if (i == elementoMoch.length) {
            return opt;
        }
        if (elementoMoch[i] != null) {
            opt.agregarElemento(elementoMoch[i], 0);
            comprobar(elementoMoch, i + 1, opt);
            return opt;
        } else {
            return comprobar(elementoMoch, i + 1, opt);
        }
    }


    /**
     * MÉTODO PARA RECORRER LA MOCHILA Y COMPARAR SUS ELEMENTOS INTERNOS.
     */
    public static void recorrer(Mochila base, Elemento[] elementos, Mochila opt, boolean lleno, int i) {

           if (i != elementos.length) {
                if (!base.existeElemento(elementos[i], 0)) {
                    if (base.getPesoMáximo() > base.getPeso() + elementos[i].getPeso()) {
                        base.agregarElemento(elementos[i], 0);
                        llenarMochila(base, elementos, opt, false);
                        base.eliminarElemento(elementos[i], 0);

                    } else {
                        llenarMochila(base, elementos, opt, true);
                    }
                }
               recorrer(base,elementos,opt,lleno,i+1);
           }
    }
}







