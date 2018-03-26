/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prueba;

import com.aop.Alumno;
import com.aop.Instituto;
import com.profesor.EstudianteAspecto;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.profesor.IInstructor;
import com.profesor.ProfesorMultifuncion;

public class testAop {

    public static void main(String[] args) {
        ApplicationContext ctx
                = new ClassPathXmlApplicationContext("com/configuracion/spring/applicationContext.xml");
        //primer y segundo ejemplo
//        IInstructor iInstructor = (IInstructor) ctx.getBean("idBeanProfesor");
//        iInstructor.ejecutar();

        //tercer ejemplo funciones en una clase
//        IInstructor iInstructor = (IInstructor) ctx.getBean("idBeanProfesor");
//        iInstructor.ejecutar();
        //cuarto ejemplo funciones en un paquete
//        Alumno alumno = (Alumno) ctx.getBean("alumno");
//        alumno.getRecibirNotas();
//        
//         Instituto instituto = (Instituto) ctx.getBean("instituto");
//        instituto.emitirCertificado();

       //quinto ejemplo funciones que empiecen con get
        Alumno alumno = (Alumno) ctx.getBean("alumno");
        alumno.enviarTareas();
        alumno.getRecibirNotas();

    }
}
