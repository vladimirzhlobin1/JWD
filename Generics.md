Вопрос В какой версии Java появились параметризованные типы?
Ответ. Дженерики появились в Java 1.5 и призваны обезопасить код от неправильной типизации. Параметризируя класс, интерфейс или метод, можно добиться гибкости
в переиспользовании алгоритмов, строгой проверки типов и упростить написание кода.
Источник. https://annimon.com/article/2637

Вопрос Приведите 2 примера кода: первый без параметризованного типа; второй -
этот же код с параметризованным
типом, иллюстрирующий преимущество данного варианта.
public class SimpleBox {
private Object obj;
public Object getObj() {
return obj;
}
public void setObj(Object obj) {
this.obj = obj;
}
public SimpleBox(Object obj) {
this.obj = obj;
}
}
public class BoxDemoApp {
public static void main(String[] args) {
SimpleBox intBox1 = new SimpleBox(20);
SimpleBox intBox2 = new SimpleBox(30);
if (intBox1.getObj() instanceof Integer && intBox2.getObj() instanceof
Integer) {
int sum = (Integer)intBox1.getObj() + (Integer)intBox2.getObj();
System.out.println("sum = " + sum);
} else {
System.out.println("Содержимое коробок отличается по типу");
}
// вызываем какой-нибудь метод, которому отдаём intBox1,
// и этот метод кладёт в коробку String
intBox1.setObj("Java");
// продолжаем наш код и при выполнении получим ClassCastException
int secondSum = (Integer)intBox1.getObj() + (Integer)intBox2.getObj();
}
}


----------------------------------------------
public class TwoGen<T, V> {
private T obj1;
private V obj2;
public TwoGen(T obj1, V obj2) {
this.obj1 = obj1;
this.obj2 = obj2;
}
public void showTypes() {
System.out.println("Тип T: " + obj1.getClass().getName());
System.out.println("Тип V: " + obj2.getClass().getName());
}
public T getObj1() {
return obj1;
}
public V getObj2() {
return obj2;
}
}
public class SimpleGenApp {
public static void main(String args[]) {
TwoGen<Integer, String> twoGenObj = new TwoGen<Integer, String>(555,
"Hello");
twoGenObj.showTypes();
int intValue = twoGenObj.getObj1();
String strValue = twoGenObj.getObj2();
System.out.println(intValue);
System.out.println(strValue);
}
}

Вопрос Какие типы данных запрещены в качестве параметров классов?
Ответ В качестве параметров классов запрещено применять базовые типы.
https://programka.com.ua/rukovodstvo/kod/chto-nelzja-parametrizovat-java


Дан код:
class Gen <T1, T2 extends Number, T3 extends Object> { … }
Какие типы можно использовать в качестве аргументов T1, T2, T3?
Byte, Integer, Double, Short, Float, Long, Object

Дан код:
class Gen1 <T> { … }
class Gen2 <T extends Object> { … }
class Runner {
private final static Gen1<Object> g11 = new Gen1<>();
private final static Gen1 g12 = new Gen1();
private final static Gen2<Object> g21 = new Gen2<>();
private final static Gen2 g22 = new Gen2();
...
}
Вопрос В чем различие объявления классов Gen1 и Gen2?
параметр T может импользовать и наследовать только T параметр, а Gen2 может наследовать Object
Вопрос Есть ли преимущество в объявлении g11 по сравнению с g12? Обоснуйте ответ.
в пермом случае в параметр помещаются объекты типа Object во втором только типа Gen
Вопрос Есть ли преимущество в объявлении g21 по сравнению с  g12? Обоснуйте ответ.

Вопрос В каком случае используется второй способ (g12, g22)?


Вопрос Дан код:
class SubInfo extends Info { … }
class Gen1 <T> { … }
class Gen2 <T extends Info> { … }
Является ли декларация Gen1<Info> подклассом Gen2<Info>?
нет

Является ли декларация Gen1<SubInfo> подклассом Gen1<Info>?

Является ли декларация Gen2<SubInfo> подклассом Gen2<Info>?
да

Почему нельзя вызвать конструктор generic-типа?

экземпляр объекта не создан

Почему нельзя создать generic-поле?
тип переменной объявляется при её создании
Почему статический метод не может иметь generic-параметр?
Если метод статический, то унаследовать параметр типа от класса он не может. Это вызвано тем, что параметр типа привязывается к конкретному объекту при его создании, а статический метод не привязан к конкретному объекту, он привязан к классу в целом. В случае статического метода параметр типа нужно указывать непосредственно перед объявлением метода

Предложите более эффективную запись данного кода:
<T> void make1(Gen <T extends Object> gen) { … }
<T, S extends T> void make2(Info<T> info1, Info<S> info2) { … }
???????????????????????////
Дан код:
class Info {
public <T1> Info() { … }
public <T2> Info(T2 t2) { … }
public <T1> void make1(T1 t1) { … }
public <T3> void make2() { … }
}
Создайте какой-либо экземпляр класса Info
конструктором без аргументов,
конструктором с аргументом.
Синтаксически правильно вызовите методы make1() и make2().
????????????????????????????/
Поясните данный код:
static <T extends Object & Comparable<? super T>> T max(Collection<? extends T> coll)

Тип T наследуется от Object и интерфейса Comparable который принимает любой тип наслелуемы от T
Бонусное задание (не обязательное)
Создать статический метод, который возвращает максимальный элемент в массиве объектов
ссылочного типа. Если массив пустой, то выбросить исключение.
Привести демо пример использования метода на примере классов
class Product {
private String name;
private Byn price;
...
}
class Purchase {
private Product product;
private int number;
...
}
Найти максимальный элемент в массиве товаров по какому-либо критерию.
Найти максимальный элемент в массиве покупок по критерию - стоимость покупки.

Ограничения:
тип Object не использовать,
даункасты (преобразования к подклассу) запрещены.

Подсказка
---------------------
Создайте интерфейс, параметризованный информационным классом.
В интерфейсе объявите метод, задающий отношение “выше”.
---------------------



