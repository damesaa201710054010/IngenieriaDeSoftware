/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

/**
 *
 * @author danys
 */
public class Respuesta {
    public String reespuestaEspecifica(boolean respuesta, String cita, String keyWord)
    {
        String respuestaFinal = "";
        if(respuesta)
        {
            respuestaFinal = "El siguiente libro o autor fue encontrado en la biblioteca: "+ keyWord +"\nSe sugiere ademas la siguiente cita en norma APA: "
                    + cita;
        }else if(!respuesta)
        {
            respuestaFinal = "El siguiente libro o autor no fue encontrado en la biblioteca: "+ keyWord;
        }
        return respuestaFinal;
    }
}
