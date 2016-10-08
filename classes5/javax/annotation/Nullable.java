package javax.annotation;

import java.lang.annotation.Annotation;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import javax.annotation.meta.TypeQualifierNickname;
import javax.annotation.meta.When;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Nonnull(when=When.UNKNOWN)
@TypeQualifierNickname
public @interface Nullable {}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\javax\annotation\Nullable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */