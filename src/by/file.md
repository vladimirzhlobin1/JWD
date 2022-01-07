
Как по терминологии Java называются базовый класс и наследуемый класс?

Ответ.  базовый класс (base class) или суперкласс – это класс, который служит основой для другого (других классов). В терминологии языка Java используется термин суперкласс;
производный класс (derived class) или подкласс – это класс, который наследует код базового класса. В терминологии Java используется термин подкласс. Подкласс имеет возможность дополнять базовый класс дополнительными полями и методами. Также подкласс имеет возможность «перегружать» или переопределять методы суперкласса

Источник. https://www.bestprog.net/ru/2018/10/05/inheritance-basic-concepts-base-class-and-derived-class-the-keyword-extends-hiding-data-in-derived-classes-access-modifiers-private-protected-public_ru/

Какой класс является родительским для всех классов?
Ответ.Класс, который наследует свойства другого, известен как дочерний класс (производный, подкласс), а класс, свойства которого наследуются, известен как родительский класс (базовый, суперкласс).
Источник.https://hr-vector.com/java/kakie-java-roditel-i-rebenok-klassy

Какой класс является родительским для всех перечислений?

Ответ.Object
Во время компиляции класс enum  будет преобразован в обычный класс:

Источник.


Какой интерфейс является родительским для всех интерфейсов?
Ответ.java.lang.Enum
Источник.https://javarush.ru/quests/lectures/questsyntaxpro.level13.lecture05

Сформулируйте критерий отношения наследования между двумя сущности физического мира.
Другими словами, какому условию должны удовлетворять две сущности физического мира, чтобы соответствующие им классы были связаны отношением наследования?

Ответ.
Источник.


Есть ли отношение наследования между сущностями:
а) квадрат и прямоугольник; нет - квадрат является фигурой как и прямоугольник. Они наследуются от класса фигура а не от друг друга
б) сосна и доска; нет, несопоставимые классы. Доска не состоит из сосны и обратно, и не является
в) книга и страница? да страница наследуюется от книги, has a
Поясните ответ.
Ответ.
Источник.


В jdk класс RuntimeException является подклассом Exception.
Есть ли нарушение критерия наследования?
RuntimeException наследуется от Exception потому-что непроверяемое исключение это все еще исключение, а не ошибка: его можно обработать и оно всегда зависит от кода, а не от сторонних, системных, факторов. И если разработчик решит обрабатывать все исключения:то должны обрабатываться и возникшие RuntimeException.

Поясните ответ.
Ответ.
Источник.


В чем смысл конструкции  super?
Перечислите случаи, когда используется конструкция  super.
В каких случаях можно обойтись без неё, т.е. заменить другими синтаксическими
возможностями. Если можно, то каким образом?
Ответ.Если ваш метод переопределяет один из методов своего суперкласса, вы можете вызвать переопределенный метод с помощью ключевого слова super. Вы также можете использовать superдля ссылки на скрытое поле (хотя скрытие полей не рекомендуется).
Для вызова конструктора супер класса: super(списокАргументов);
Для обращения к члену супер класса, скрываемому членом подкласса: suреr.member;
Делегирование полномочий одного класса (методов) другому.
interface Graphics {void draw}
class A {void draw(){}}
class B {void draw(){}}
class Painter {
Graphics graph;
void setGraph (Graph g){
graph = g;
}
void draw ()
{
graph.draw ();
}
}

Источник.https://docs.oracle.com/javase/tutorial/java/IandI/super.html


Можно ли одновременно использовать this() и super() в конструкторе?
Поясните ответ.Оба this() и super() являются вызовами конструктора.
Конструкторский вызов всегда должен быть первым выражением. Таким образом, мы не можем иметь два оператора в качестве первого оператора, поэтому мы можем вызывать super() или мы можем вызвать this() из конструктора, но не оба.
Ответ.
Источник.


Дан код.
class SomeClass() {
...
public SomeClass() {
doSmth();
}
protected void doSmth() {
...
}
}
Это потенциальный антипаттерн. Почему?

Ответ.метод вызывается в том же классе где и создан
Источник.
Мыша, [04.01.2022 10:06]
Будем  в большом евроопте

Valdemar Zhlobinski, [07.01.2022 20:01]
[ Album ]

Valdemar Zhlobinski, [07.01.2022 21:37]
Как по терминологии Java называются базовый класс и наследуемый класс?

Ответ.  базовый класс (base class) или суперкласс – это класс, который служит основой для другого (других классов). В терминологии языка Java используется термин суперкласс;
производный класс (derived class) или подкласс – это класс, который наследует код базового класса. В терминологии Java используется термин подкласс. Подкласс имеет возможность дополнять базовый класс дополнительными полями и методами. Также подкласс имеет возможность «перегружать» или переопределять методы суперкласса

Источник. https://www.bestprog.net/ru/2018/10/05/inheritance-basic-concepts-base-class-and-derived-class-the-keyword-extends-hiding-data-in-derived-classes-access-modifiers-private-protected-public_ru/

Какой класс является родительским для всех классов?
Ответ.Класс, который наследует свойства другого, известен как дочерний класс (производный, подкласс), а класс, свойства которого наследуются, известен как родительский класс (базовый, суперкласс).
Источник.https://hr-vector.com/java/kakie-java-roditel-i-rebenok-klassy

Какой класс является родительским для всех перечислений?

Ответ.Object
Во время компиляции класс enum  будет преобразован в обычный класс:

Источник.


Какой интерфейс является родительским для всех интерфейсов?
Ответ.java.lang.Enum
Источник.https://javarush.ru/quests/lectures/questsyntaxpro.level13.lecture05

Сформулируйте критерий отношения наследования между двумя сущности физического мира.
Другими словами, какому условию должны удовлетворять две сущности физического мира, чтобы соответствующие им классы были связаны отношением наследования?

Ответ.
Источник.


Есть ли отношение наследования между сущностями:
а) квадрат и прямоугольник; нет - квадрат является фигурой как и прямоугольник. Они наследуются от класса фигура а не от друг друга
б) сосна и доска; нет, несопоставимые классы. Доска не состоит из сосны и обратно, и не является
в) книга и страница? да страница наследуюется от книги, has a
Поясните ответ.
Ответ.
Источник.


В jdk класс RuntimeException является подклассом Exception.
Есть ли нарушение критерия наследования?
RuntimeException наследуется от Exception потому-что непроверяемое исключение это все еще исключение, а не ошибка: его можно обработать и оно всегда зависит от кода, а не от сторонних, системных, факторов. И если разработчик решит обрабатывать все исключения:то должны обрабатываться и возникшие RuntimeException.

Поясните ответ.
Ответ.
Источник.


В чем смысл конструкции  super?
Перечислите случаи, когда используется конструкция  super.
В каких случаях можно обойтись без неё, т.е. заменить другими синтаксическими
возможностями. Если можно, то каким образом?
Ответ.Если ваш метод переопределяет один из методов своего суперкласса, вы можете вызвать переопределенный метод с помощью ключевого слова super. Вы также можете использовать superдля ссылки на скрытое поле (хотя скрытие полей не рекомендуется).
Для вызова конструктора супер класса: super(списокАргументов);
Для обращения к члену супер класса, скрываемому членом подкласса: suреr.member;
Делегирование полномочий одного класса (методов) другому.
interface Graphics {void draw}
class A {void draw(){}}
class B {void draw(){}}
class Painter {
Graphics graph;
void setGraph (Graph g){
graph = g;
}
void draw ()
{
graph.draw ();
}
}

Источник.https://docs.oracle.com/javase/tutorial/java/IandI/super.html


Можно ли одновременно использовать this() и super() в конструкторе?
Поясните ответ.Оба this() и super() являются вызовами конструктора.
Конструкторский вызов всегда должен быть первым выражением. Таким образом, мы не можем иметь два оператора в качестве первого оператора, поэтому мы можем вызывать super() или мы можем вызвать this() из конструктора, но не оба.
Ответ.
Источник.


Дан код.
class SomeClass() {
...
public SomeClass() {
doSmth();
}
protected void doSmth() {
...
}
}
Это потенциальный антипаттерн. Почему?

Ответ.метод вызывается в том же классе где и создан
Источник.
Пусть I - интерфейс, i - ссылка на I, b - ссылка на B, класс В реализует интерфейс I. Можно ли создать объект класса В по ссылке i? Можно ли выполнить операции:
1. b = i; ?
2. i = b; ?
   Ответ.
   Источник.


В чем заключается отличие сравнения принадлежности к классу через операцию instanceof и метод getClass()?
Ответ.

    instanceof проверяет, является ли ссылка объекта в левой части экземпляром типа в правой части или некоторым подтипом.

    getClass() == ... проверяет, идентичны ли типы.
Источник.


Можно ли создать:
1. ссылку на объект абстрактного класса? нет объекта Но абстрактные классы можно применять для создания ссылок на объекты
2. объект абстрактного класса? нет
3. ссылку на интерфейс? Интерфейсные ссылки. При создании объектов класса в качестве типа объектной переменной может указываться имя реализованного в классе интерфейса. Другими словами, если класс реализует интерфейс, то ссылку на объект этого класса можно присвоить интерфейсной переменной — переменной, в качестве типа которой указано имя соответствующего интерфейса.
4. объект типа интерфейс?
   Ответ.
   Источник.


Может ли класс:
1. реализовывать два интерфейса? да
2. расширять два класса? нет только через методы интерфейса
3. расширять два интерфейса?нет
4. расширять один класс и реализовывать один интерфейс? да
5. расширять сам себя?  Определение подкласса заключается в том, что он расширяет другой класс и наследует состояние и поведение этого класса. Класс не может расширяться, так как он сам IS, поэтому он не является подклассом. Внутренние классы могут расширять внешний класс, потому что это два разных класса.

Ответ.
Источник.

Для каких целей используется расширение интерфейса? для наследования методов интерфейс может расширить более чем один родительский интерфейс.
Ответ.Интерфейс содержит переменные и методы, подобные классу, но методы интерфейса по умолчанию абстрактны в отличие от класса. Интерфейс расширяет другой интерфейс, как класс реализует интерфейс в наследовании интерфейса.
Источник.


Могут ли в интерфейсе быть поля?
Интерфейсы могут содержать поля, так же как и обычные классы, но с несколькими отличиями:
Ответ.Поля должны быть проинициализированы
Поля считаются публичными статическими финальными
Модификаторы public, static и final не нужно указывать явно (они «проставляются» по умолчанию)

Источник.https://habr.com/ru/post/482498/


Можно ли в интерфейсе
1. объявить метод с пакетным уровнем доступа?
2. объявить конструктор?
3. определить конструктор? Ссылка на конструктор может быть присвоена ссылке на функциональный интерфейс при условии, что сигнатура конструктора совместима с сигнатурой метода функционального интерфейса
   public class Triangle {
   private double a, b, c;
   public Triangle(double a, double b, double c) {
   this.a = a; this.b = b; this.c = c;}
   public double GetA() { return a; }
   public double GetB() { return b; }
   public double GetC() { return c; }
   public void Print(String text) {
   System.out.println(text);
   System.out.println("a = " + a + ", b = " + b + ", c = " + c);}}
   public interface IFunction {

        Triangle Function(double a, double b, double c);
   }
   .
   Ответ.
   Источник.


Можно ли интерфейс объявить финальным? Поясните ответ.
Ответ.Интерфейсы являются абстрактными 100%, и единственный способ создать экземпляр интерфейса - создать экземпляр класса, который его реализует. Разрешение интерфейсов final совершенно бессмысленно.
Источник.


Можно ли в интерфейсе объявить статический метод? Поясните ответ.
Ответ.Подобно методу по умолчанию в интерфейсе , статический метод в интерфейсе может быть определен в интерфейсе, но эти методы нельзя переопределить в классах реализации. Чтобы использовать статический метод, имя интерфейса должно создаваться вместе с ним, поскольку оно является частью только интерфейса.
Источник.
http://espressocode.top/static-method-in-interface-in-java/
Мыша, [04.01.2022 10:06]
Будем  в большом евроопте

Valdemar Zhlobinski, [07.01.2022 20:01]
[ Album ]

Valdemar Zhlobinski, [07.01.2022 21:37]
Как по терминологии Java называются базовый класс и наследуемый класс?

Ответ.  базовый класс (base class) или суперкласс – это класс, который служит основой для другого (других классов). В терминологии языка Java используется термин суперкласс;
производный класс (derived class) или подкласс – это класс, который наследует код базового класса. В терминологии Java используется термин подкласс. Подкласс имеет возможность дополнять базовый класс дополнительными полями и методами. Также подкласс имеет возможность «перегружать» или переопределять методы суперкласса

Источник. https://www.bestprog.net/ru/2018/10/05/inheritance-basic-concepts-base-class-and-derived-class-the-keyword-extends-hiding-data-in-derived-classes-access-modifiers-private-protected-public_ru/

Какой класс является родительским для всех классов?
Ответ.Класс, который наследует свойства другого, известен как дочерний класс (производный, подкласс), а класс, свойства которого наследуются, известен как родительский класс (базовый, суперкласс).
Источник.https://hr-vector.com/java/kakie-java-roditel-i-rebenok-klassy

Какой класс является родительским для всех перечислений?

Ответ.Object
Во время компиляции класс enum  будет преобразован в обычный класс:

Источник.


Какой интерфейс является родительским для всех интерфейсов?
Ответ.java.lang.Enum
Источник.https://javarush.ru/quests/lectures/questsyntaxpro.level13.lecture05

Сформулируйте критерий отношения наследования между двумя сущности физического мира.
Другими словами, какому условию должны удовлетворять две сущности физического мира, чтобы соответствующие им классы были связаны отношением наследования?

Ответ.
Источник.


Есть ли отношение наследования между сущностями:
а) квадрат и прямоугольник; нет - квадрат является фигурой как и прямоугольник. Они наследуются от класса фигура а не от друг друга
б) сосна и доска; нет, несопоставимые классы. Доска не состоит из сосны и обратно, и не является
в) книга и страница? да страница наследуюется от книги, has a
Поясните ответ.
Ответ.
Источник.


В jdk класс RuntimeException является подклассом Exception.
Есть ли нарушение критерия наследования?
RuntimeException наследуется от Exception потому-что непроверяемое исключение это все еще исключение, а не ошибка: его можно обработать и оно всегда зависит от кода, а не от сторонних, системных, факторов. И если разработчик решит обрабатывать все исключения:то должны обрабатываться и возникшие RuntimeException.

Поясните ответ.
Ответ.
Источник.


В чем смысл конструкции  super?
Перечислите случаи, когда используется конструкция  super.
В каких случаях можно обойтись без неё, т.е. заменить другими синтаксическими
возможностями. Если можно, то каким образом?
Ответ.Если ваш метод переопределяет один из методов своего суперкласса, вы можете вызвать переопределенный метод с помощью ключевого слова super. Вы также можете использовать superдля ссылки на скрытое поле (хотя скрытие полей не рекомендуется).
Для вызова конструктора супер класса: super(списокАргументов);
Для обращения к члену супер класса, скрываемому членом подкласса: suреr.member;
Делегирование полномочий одного класса (методов) другому.
interface Graphics {void draw}
class A {void draw(){}}
class B {void draw(){}}
class Painter {
Graphics graph;
void setGraph (Graph g){
graph = g;
}
void draw ()
{
graph.draw ();
}
}

Источник.https://docs.oracle.com/javase/tutorial/java/IandI/super.html


Можно ли одновременно использовать this() и super() в конструкторе?
Поясните ответ.Оба this() и super() являются вызовами конструктора.
Конструкторский вызов всегда должен быть первым выражением. Таким образом, мы не можем иметь два оператора в качестве первого оператора, поэтому мы можем вызывать super() или мы можем вызвать this() из конструктора, но не оба.
Ответ.
Источник.


Дан код.
class SomeClass() {
...
public SomeClass() {
doSmth();
}
protected void doSmth() {
...
}
}
Это потенциальный антипаттерн. Почему?

Ответ.метод вызывается в том же классе где и создан
Источник.

Valdemar Zhlobinski, [07.01.2022 21:40]
Можно ли вызвать статический метод через объектную ссылку? Поясните ответ. У класса можно вызвать только статический метод, для вызова обычного метода нужна ссылка на экземпляр класса. Поэтому нельзя вызвать обычный метод конструкцией вида ИмяКласса.имяМетода(параметры).
Ответ.
Источник.


Можно ли создать экземпляр класса, у которого есть абстрактный метод? Если да, то зачем?
Ответ.нет абстрактный класс должен быть с абстрактными методами

Источник.


Должен ли иметь абстрактный класс хотя бы один абстрактный метод? Если нет, то зачем объявлять такой класс абстрактным?
нет
класс, который реализует интерфейс, должен реализовать все методы интерфейса. Однако можно определить класс, который не реализует все методы интерфейса, при условии, что класс объявлен абстрактным. Ответ. Источник.


Что означает ключевое слово final в следующих конструкциях?
1.
public final class SomeClass() { }
от этого класса нельзя наследоваться
2.
public class SomeClass() {
public final void doSmth();
метод не подлежит переопределению
}
Ответ.
Источник.

Можно ли объявить метод одновременно финальным и абстрактным? Поясните ответ.нет
Ответ.
Источник.
К каким методам неприменимы принципы позднего связывания? Почему?
Ответ.К статическим методам принципы «позднего связывания» неприменимы. При использовании ссылки для доступа к статическому члену компилятор при выборе метода или поля учитывает тип ссылки, а не тип объекта, ей присвоенного.
Источник.
В чем заключается отличие между ранним и поздним связыванием?
Ответ.Раннее связывание - это когда метод, который будет вызван, известен во время компиляции, например, вызов статического метода. Кстати, то что вы называете поздним связываением, есть скорее dynamic dispatch. Позднее связывание - это когда вызов метода может быть осуществлен только во время выполнения и у компилятора нет информации, чтобы проверить корректность такого вызова.
Источник.
Бонусное задание 1 (необязательное)
Добавить к задаче inheritance2 пункт:
8. Найти в отсортированном массиве ВСЕ покупки со стоимостью 5.00 BYN, для первоначального поиска использовав метод Arrays.binarySearch( ).
   Желательно найти такое решение, которое после поиска позволяет выполнить задачу за один цикл.
   Трюки типа Arrays.copyOfRange() не засчитываются, т.к. они реализованы через цикл.
   То есть если быть максимально точным, то должен быть один цикл, и вычислительная сложность алгоритма после вызова метода Arrays.binarySearch( ) должна быть равна O(n).
   Подсказка 1 - это решение существует )
   Подсказка 2
   ----------------- см. следующую строку -------------
   В чем смысл отрицательного значения метода binarySearch()?
---------------------------------------------------------------