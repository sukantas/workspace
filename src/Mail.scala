
//test once in staging
import org.apache.velocity.app.VelocityEngine
import java.io.StringWriter
import org.apache.velocity.runtime.RuntimeConstants
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader
import org.apache.velocity.{Template, VelocityContext}


object Mail {

  def main(args: Array[String]): Unit = {
   
    val context = new VelocityContext
    context.put("userName", "sukanta")
    context.put("password", "****")
    context.put("loginEmailId","qlwdkjas@gmail.com")

    println(TemplateUtil.signupEmailTemplate(context))


  
  }

}
