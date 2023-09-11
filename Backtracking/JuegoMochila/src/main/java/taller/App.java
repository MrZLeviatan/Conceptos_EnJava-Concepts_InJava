package taller;

public class App {

    public static void main(String[] args) {

        Elemento[] elementos = {

                new Elemento(1, 5),
                new Elemento(2, 2),
                new Elemento(4, 18),
                new Elemento(4, 30),
                new Elemento(10, 1),
        };

        Mochila base = new Mochila(elementos.length, 15);
        Mochila opt = new Mochila(elementos.length, 15);


        System.out.println("-- JUEGO DE LA MOCHILA --");
        llenarMochila(base, elementos, opt, false);
        System.out.println(opt);
    }

    public static void llenarMochila(Mochila base, Elemento[] elementos, Mochila opt, boolean lleno) {

        if (lleno) {
            if (base.getBeneficios() > opt.getBeneficios()) {
                Elemento[] elementosMochBase = base.getElementos();
                opt.clear(0);
                comprobrar(elementosMochBase, 0, opt);
            }
        }else{
            recorrer(base,elementos,opt,false,0);
        }
    }

    public static Mochila comprobrar(Elemento[] elementoMoch, int i, Mochila opt) {

        if (i == elementoMoch.length) {
            return opt;
        }
        if (elementoMoch[i] != null) {
            opt.anadirElemento(elementoMoch[i], 0);
            comprobrar(elementoMoch, i + 1, opt);
            return opt;
        } else {
            return comprobrar(elementoMoch, i + 1, opt);
        }
    }

    public static void recorrer(Mochila base, Elemento[] elementos, Mochila opt, boolean lleno, int i) {

           if (i != elementos.length) {
                if (!base.existeElemento(elementos[i], 0)) {
                    if (base.getPesoMaximo() > base.getPeso() + elementos[i].getPeso()) {
                        base.anadirElemento(elementos[i], 0);
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







