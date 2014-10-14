import org.apache.velocity.app.VelocityEngine
import java.io.StringWriter
import org.apache.velocity.runtime.RuntimeConstants
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader
import org.apache.velocity.{Template, VelocityContext}

object TemplateUtil {
  
  lazy val ve: VelocityEngine = {
    val tmp = new VelocityEngine
    tmp.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath")
    tmp.setProperty("classpath.resource.loader.class", classOf[ClasspathResourceLoader].getName)
    
    tmp.init
    tmp
  }

  lazy val signupEmailTemplate = ve.getTemplate("template/emailbody_html_registration.vm")

  def signupEmailTemplate(context: VelocityContext): String = (doit(signupEmailTemplate, context))


  def doit(t: Template, context: VelocityContext): String = {
    val writer = new StringWriter
    t.merge(context, writer)
    writer.toString
  }

}