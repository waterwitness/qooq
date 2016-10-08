package com.tencent.mobileqq.persistence;

import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TableBuilder
{
  public static final String a = "_id";
  public static final Map a;
  private static final Map b;
  private static final Map c;
  private static final Map d;
  private static final Map e;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    a = new HashMap();
    b = new ConcurrentHashMap();
    c = new ConcurrentHashMap();
    d = new ConcurrentHashMap();
    e = new ConcurrentHashMap();
    a.put(Byte.TYPE, "INTEGER");
    a.put(Boolean.TYPE, "INTEGER");
    a.put(Short.TYPE, "INTEGER");
    a.put(Integer.TYPE, "INTEGER");
    a.put(Long.TYPE, "INTEGER");
    a.put(String.class, "TEXT");
    a.put(byte[].class, "BLOB");
    a.put(Float.TYPE, "REAL");
    a.put(Double.TYPE, "REAL");
  }
  
  public static Entity a(Class paramClass)
  {
    Entity localEntity2 = (Entity)e.get(paramClass);
    Entity localEntity1 = localEntity2;
    if (localEntity2 == null)
    {
      localEntity1 = (Entity)paramClass.newInstance();
      e.put(paramClass, localEntity1);
    }
    return localEntity1;
  }
  
  public static String a(Entity paramEntity)
  {
    String str1 = paramEntity.getTableName();
    if (d.containsKey(str1)) {
      return (String)d.get(str1);
    }
    Object localObject1 = OGEntityDaoManager.a().a(paramEntity.getClass());
    if (localObject1 != null)
    {
      localObject2 = ((OGAbstractDao)localObject1).a(str1);
      if (localObject2 != null)
      {
        d.put(str1, localObject2);
        ((OGAbstractDao)localObject1).a = true;
        return (String)localObject2;
      }
    }
    localObject1 = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
    ((StringBuilder)localObject1).append(str1);
    ((StringBuilder)localObject1).append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT");
    paramEntity = paramEntity.getClassForTable();
    Object localObject2 = a(paramEntity);
    int j = ((List)localObject2).size();
    int i = 0;
    if (i < j)
    {
      Field localField = (Field)((List)localObject2).get(i);
      String str2 = localField.getName();
      Object localObject3 = localField.getType();
      localObject3 = (String)a.get(localObject3);
      if (localObject3 != null)
      {
        ((StringBuilder)localObject1).append(',');
        ((StringBuilder)localObject1).append(str2 + " " + (String)localObject3);
        if (!localField.isAnnotationPresent(unique.class)) {
          break label234;
        }
        ((StringBuilder)localObject1).append(" UNIQUE");
      }
      for (;;)
      {
        i += 1;
        break;
        label234:
        if (localField.isAnnotationPresent(defaultzero.class)) {
          ((StringBuilder)localObject1).append(" default 0");
        } else if (localField.isAnnotationPresent(defaultValue.class)) {
          ((StringBuilder)localObject1).append(" default " + ((defaultValue)localField.getAnnotation(defaultValue.class)).a());
        }
      }
    }
    if (paramEntity.isAnnotationPresent(uniqueConstraints.class))
    {
      paramEntity = (uniqueConstraints)paramEntity.getAnnotation(uniqueConstraints.class);
      localObject2 = paramEntity.columnNames();
      ((StringBuilder)localObject1).append(",UNIQUE(" + (String)localObject2 + ")");
      paramEntity = paramEntity.clause().toString();
      ((StringBuilder)localObject1).append(" ON CONFLICT " + paramEntity);
    }
    ((StringBuilder)localObject1).append(')');
    paramEntity = ((StringBuilder)localObject1).toString();
    d.put(str1, paramEntity);
    return paramEntity;
  }
  
  public static String a(Class paramClass)
  {
    return a(paramClass).getTableName();
  }
  
  public static String a(String paramString)
  {
    return "DROP TABLE IF EXISTS " + paramString;
  }
  
  public static String a(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    return a(paramString1, paramString2, paramString3, paramBoolean, 0);
  }
  
  public static String a(String paramString1, String paramString2, String paramString3, boolean paramBoolean, int paramInt)
  {
    if (paramBoolean) {
      return "alter table " + paramString1 + " add " + paramString2 + " " + paramString3 + " default " + paramInt;
    }
    return "alter table " + paramString1 + " add " + paramString2 + " " + paramString3;
  }
  
  public static List a(Entity paramEntity)
  {
    Class localClass = paramEntity.getClassForTable();
    Object localObject1 = (List)b.get(localClass);
    paramEntity = (Entity)localObject1;
    if (localObject1 == null)
    {
      localObject1 = localClass.getFields();
      paramEntity = new ArrayList(localObject1.length);
      int j = localObject1.length;
      int i = 0;
      while (i < j)
      {
        Object localObject2 = localObject1[i];
        if ((!Modifier.isStatic(((Field)localObject2).getModifiers())) && (!((Field)localObject2).isAnnotationPresent(notColumn.class))) {
          paramEntity.add(localObject2);
        }
        i += 1;
      }
      b.put(localClass, paramEntity);
    }
    return paramEntity;
  }
  
  public static List a(Class paramClass)
  {
    Object localObject1;
    try
    {
      paramClass = a(paramClass).getClassForTable();
      Object localObject2 = (List)b.get(paramClass);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject2 = paramClass.getFields();
        localObject1 = new ArrayList(localObject2.length);
        int j = localObject2.length;
        int i = 0;
        while (i < j)
        {
          Object localObject3 = localObject2[i];
          if ((!Modifier.isStatic(((Field)localObject3).getModifiers())) && (!((Field)localObject3).isAnnotationPresent(notColumn.class))) {
            ((List)localObject1).add(localObject3);
          }
          i += 1;
        }
      }
    }
    catch (InstantiationException paramClass)
    {
      for (;;)
      {
        paramClass.printStackTrace();
        paramClass = null;
      }
    }
    catch (IllegalAccessException paramClass)
    {
      for (;;)
      {
        paramClass.printStackTrace();
        paramClass = null;
      }
      b.put(paramClass, localObject1);
    }
    return (List)localObject1;
  }
  
  public static String b(Entity paramEntity)
  {
    if ((paramEntity instanceof MessageRecord))
    {
      MessageRecord localMessageRecord = (MessageRecord)paramEntity;
      paramEntity = localMessageRecord.getTableName();
      StringBuilder localStringBuilder = new StringBuilder("CREATE INDEX IF NOT EXISTS ");
      localStringBuilder.append(paramEntity).append("_idx");
      localStringBuilder.append(" ON ");
      localStringBuilder.append(paramEntity);
      paramEntity = "time";
      switch (localMessageRecord.istroop)
      {
      }
      for (;;)
      {
        localStringBuilder.append("(").append(paramEntity).append(", _id)");
        return localStringBuilder.toString();
        paramEntity = "shmsgseq";
      }
    }
    return null;
  }
  
  public static String b(Class paramClass)
  {
    try
    {
      paramClass = a(paramClass);
      return paramClass;
    }
    catch (InstantiationException paramClass)
    {
      paramClass.printStackTrace();
      return null;
    }
    catch (IllegalAccessException paramClass)
    {
      for (;;)
      {
        paramClass.printStackTrace();
      }
    }
  }
  
  public static List b(Entity paramEntity)
  {
    Class localClass = paramEntity.getClassForTable();
    Object localObject1 = (List)c.get(localClass);
    paramEntity = (Entity)localObject1;
    if (localObject1 == null)
    {
      localObject1 = localClass.getFields();
      paramEntity = new ArrayList(localObject1.length);
      int j = localObject1.length;
      int i = 0;
      while (i < j)
      {
        Object localObject2 = localObject1[i];
        if (!Modifier.isStatic(((Field)localObject2).getModifiers())) {
          paramEntity.add(localObject2);
        }
        i += 1;
      }
      c.put(localClass, paramEntity);
    }
    return paramEntity;
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\persistence\TableBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */