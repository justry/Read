package fr.masciulli.read.data;

import org.joda.time.DateTime;

import java.util.ArrayList;
import java.util.List;

public class ArticleItemProvider {

    public static List<ArticleItem> getItems(FeedItem feedItem) {
        List<ArticleItem> articleItems = new ArrayList<ArticleItem>();

        for (int i = 0; i < 3; i++) {
            articleItems.add(new ArticleItem("Article title", "Alexandre Masciulli", new DateTime(), feedItem.getTitle() + " lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut non sine causa ex iis memoriae ducta sit disciplina. Quare hoc videndum est, possitne nobis hoc ratio philosophorum dare. Equidem, sed audistine modo de Carneade?\n\nDuo Reges: constructio interrete. Venit ad extremum; Huius, Lyco, oratione locuples, rebus ipsis ielunior. Id mihi magnum videtur. Si quicquam extra virtutem habeatur in bonis. Scientiam pollicentur, quam non erat mirum sapientiae cupido patria esse cariorem. Respondent extrema primis, media utrisque, omnia omnibus. Multa sunt dicta ab antiquis de contemnendis ac despiciendis rebus humanis", false));
        }

        for (int i = 0; i < 15; i++) {
            articleItems.add(new ArticleItem("Article title", "Alexandre Masciulli", new DateTime(), feedItem.getTitle() + " lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut non sine causa ex iis memoriae ducta sit disciplina. Quare hoc videndum est, possitne nobis hoc ratio philosophorum dare. Equidem, sed audistine modo de Carneade?\n\nDuo Reges: constructio interrete. Venit ad extremum; Huius, Lyco, oratione locuples, rebus ipsis ielunior. Id mihi magnum videtur. Si quicquam extra virtutem habeatur in bonis. Scientiam pollicentur, quam non erat mirum sapientiae cupido patria esse cariorem. Respondent extrema primis, media utrisque, omnia omnibus. Multa sunt dicta ab antiquis de contemnendis ac despiciendis rebus humanis", true));
        }

        return articleItems;
    }
}
