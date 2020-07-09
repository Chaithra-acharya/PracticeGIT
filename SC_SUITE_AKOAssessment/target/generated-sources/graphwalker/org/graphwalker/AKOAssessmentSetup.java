// Generated by GraphWalker (http://www.graphwalker.org)
package org.graphwalker;

import org.graphwalker.java.annotation.Model;
import org.graphwalker.java.annotation.Vertex;
import org.graphwalker.java.annotation.Edge;

@Model(file = "org/graphwalker/AKOAssessmentSetup.graphml")
public interface AKOAssessmentSetup {

    @Vertex()
    void v_ValidateAssessmentSetup();

    @Edge()
    void e_PublishAssessment();

    @Vertex()
    void v_VerifySetupPage();

    @Edge()
    void e_SelectSetupProperties();

    @Vertex()
    void v_VerifyPublishedAssessment();
}
