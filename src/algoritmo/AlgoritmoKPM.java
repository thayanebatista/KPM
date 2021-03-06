/**
 * Universidade Católica Dom Bosco
 * Atividade: Processamento de Cadeias
 * Academico: Thayane Batista RA159049
 * Docente: Marcos Alves
 * Disciplina: Estrutura de dados II
 */

package algoritmo;

/**
 * @author ra159049
 */
public class AlgoritmoKPM {
    /**
     * a função prefixo é o pre processamento que 'facilita' as comparações entre o texto e o padrão
     * @param p
     * @return 
     */
    public int[] FuncaoPrefixo(String p) {
        //varialvel m vai receber o tamanho da string p
        int m = p.length();
        int i = 1;
        int j = 0;
        int f[] = new int[p.length()];//cria f de acordo com o tamanho de p

        while (i < m) {
            //p é uma string, para comparar carcteres da string usa a função charat
            if (p.charAt(j) == p.charAt(i)) {
                f[i] = j + 1;
                i = i + 1;
                j = j + 1;
            } else if (j > 0) {
                j = f[j - 1];
            } else {
                f[i] = 0;
                i = i + 1;
            }
        }
        return f;
    }

    /**
     * a função kpm vai receber o texto e o padrao buscado
     * @param t
     * @param p
     * @return 
     */
    public int kmp(String t, String p) {
        int n = t.length();
        int m = p.length();
        int f[] = new int[p.length()]; 
        int i = 0, j = 0;
        f = FuncaoPrefixo(p);
        while (i < n) {
            if (p.charAt(j) == t.charAt(i)) {
                if (j == m - 1) {
                    return i - m + 1;
                }
                i = i + 1;
                j = j + 1;
            } else if (j > 0) {
                j = f[j - 1];
            } else {
                i = i + 1;
            }
        }
        return -1;
    }
    

    public static void main(String[] args) {
        //String texto = LE.readStringPane("Digite uma palavra: ");
        AlgoritmoKPM kmp = new AlgoritmoKPM();

        String texto = LE.readStringPane("Digite o texto:");
        String padrao = LE.readStringPane("Digite o padrão a ser encontrado");
        int k = kmp.kmp(texto, padrao);
        if (k != -1 ){
            LE.show("Posição na qual se inicia o padrão no texto é: \n"+k);
        } else {
            LE.show("Padrão não foi encontrado!!!!");
        }
    }
}
