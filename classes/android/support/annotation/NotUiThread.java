package android.support.annotation;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.SOURCE)
@Target({java.lang.annotation.ElementType.METHOD})
public @interface NotUiThread {}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\android\support\annotation\NotUiThread.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */