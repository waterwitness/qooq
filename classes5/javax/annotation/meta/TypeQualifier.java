package javax.annotation.meta;

import java.lang.annotation.Annotation;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({java.lang.annotation.ElementType.ANNOTATION_TYPE})
public @interface TypeQualifier
{
  Class<?> applicableTo() default Object.class;
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\javax\annotation\meta\TypeQualifier.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */