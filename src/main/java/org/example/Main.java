package org.example;

import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.CoreDocument;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.util.CoreMap;
import edu.stanford.nlp.util.StringUtils;

import java.io.*;
import java.util.List;
import java.util.Properties;

public class Main {


    public static void main(String... args){
        var props= StringUtils.argsToProperties("-props", "StanfordCoreNLP-arabic.properties");
        props.setProperty("annotators", "tokenize,ssplit,parse");

        String text = "اللُّغَةُ العَرَبِيَّة هي أكثر اللغات السامية تحدثًا، وإحدى أكثر اللغات انتشاراً في العالم، يتحدثها أكثر من 467 مليون نسمة.(1) ويتوزع متحدثوها في الوطن العربي، بالإضافة إلى العديد من المناطق الأخرى المجاورة كالأحواز وتركيا وتشاد ومالي والسنغال وإرتيريا وإثيوبيا وجنوب السودان وإيران. وبذلك فهي تحتل المركز الرابع أو الخامس من حيث اللغات الأكثر انتشارًا في العالم، وهي تحتل المركز الثالث تبعًا لعدد الدول التي تعترف بها كلغة رسمية؛ إذ تعترف بها 27 دولة كلغة رسمية، واللغة الرابعة من حيث عدد المستخدمين على الإنترنت. اللغةُ العربيةُ ذات أهمية قصوى لدى المسلمين، فهي عندَهم لغةٌ مقدسة إذ أنها لغة القرآن، وهي لغةُ الصلاة وأساسيةٌ في القيام بالعديد من العبادات والشعائرِ الإسلامية. العربيةُ هي أيضاً لغة شعائرية رئيسية لدى عدد من الكنائس المسيحية في الوطن العربي، كما كُتبَت بها كثير من أهمِّ الأعمال الدينية والفكرية اليهودية في العصور الوسطى. ارتفعتْ مكانةُ اللغةِ العربية إثْرَ انتشارِ الإسلام بين الدول إذ أصبحت لغة السياسة والعلم والأدب لقرون طويلة في الأراضي التي حكمها المسلمون. وللغة العربية تأثير مباشر وغير مباشر على كثير من اللغات الأخرى في العالم الإسلامي، كالتركية والفارسية والأمازيغية والكردية والأردية والماليزية والإندونيسية والألبانية وبعض اللغات الإفريقية الأخرى مثل الهاوسا والسواحيلية والتجرية والأمهرية والصومالية، وبعض اللغات الأوروبية وخاصةً المتوسطية كالإسبانية والبرتغالية والمالطية والصقلية؛ ودخلت الكثير من مصطلحاتها في اللغة الإنجليزية واللغات الأخرى، مثل أدميرال والتعريفة والكحول والجبر وأسماء النجوم. كما أنها تُدرَّس بشكل رسمي أو غير رسمي في الدول الإسلامية والدول الإفريقية المحاذية للوطن العربي.\n" +
                "\n" +
                "العربية لغةٌ رسمية في كل دول الوطن العربي إضافة إلى كونها لغة رسمية في تشاد وإريتريا. وهي إحدى اللغات الرسمية الست في منظمة الأمم المتحدة، ويُحتفل باليوم العالمي للغة العربية في 18 ديسمبر كذكرى اعتماد العربية بين لغات العمل في الأمم المتحدة. وفي سنة 2011 صنفت بلومبيرغ بيزنس ويك اللغة العربية في المرتبة الرابعة من حيث اللغات الأكثر فائدة في الأعمال التجارية على مستوى العالم. وفي 2013 نشر المجلس الثقافي البريطاني تقريرًا مفصلاً عن اللغات الأكثر طلباً في المملكة المتحدة تحت عنوان \"لغات المستقبل\" وتبين أن العربية تحتل المرتبة الثانية على مستوى العالم وفي عام 2017 احتلت المرتبة الرابعة. فيما يخص اللغات الأكثر جنيًا للأرباح في بريطانيا تأتي العربية في المرتبة الثانية وفقًا للمنظمة.";
        StanfordCoreNLP pipeline = new StanfordCoreNLP(props);
        Annotation annotation = new Annotation(text);
        pipeline.annotate(annotation);


        List<CoreMap> sentences = annotation.get(CoreAnnotations.SentencesAnnotation.class);
        for (CoreMap sentence : sentences) {
            for (CoreLabel token: sentence.get(CoreAnnotations.TokensAnnotation.class)) {
                String word = token.get(CoreAnnotations.TextAnnotation.class);
                // this is the POS tag of the token
                String pos = token.get(CoreAnnotations.PartOfSpeechAnnotation.class);
                System.out.println(word + "/" + pos);
            }
        }

    }
}