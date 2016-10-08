package javax.annotation;

import java.lang.annotation.Annotation;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import javax.annotation.meta.TypeQualifier;
import javax.annotation.meta.When;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@TypeQualifier
public @interface Untainted
{
  When when() default When.ALWAYS;
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\javax\annotation\Untainted.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */