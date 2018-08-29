package modelo;

public class IMC {
    private double peso, altura, imc;

    public IMC(double peso, double altura) {
        this.peso = peso;
        this.altura = altura;
        calcularIMC();
    }
     
    private void calcularIMC(){
        imc =  peso / (altura*altura);
    }
    
    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getImc() {
        return imc;
    }
    
    public String verificarSituacao(){
        String situacao;
        if(imc < 18.5)
            situacao = "abaixo do peso normal";
        else if(imc < 25)
            situacao = "peso normal";
        else if (imc < 30)
            situacao = "sobrepeso";
        else
            situacao = "obesidade";
        return situacao;
    }
}
