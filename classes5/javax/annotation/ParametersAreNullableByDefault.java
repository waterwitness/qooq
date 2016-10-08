package javax.annotation;

import java.lang.annotation.Annotation;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import javax.annotation.meta.TypeQualifierDefault;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Nullable
@TypeQualifierDefault({java.lang.annotation.ElementType.PARAMETER})
public @interface ParametersAreNullableByDefault {}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\javax\annotation\ParametersAreNullableByDefault.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */