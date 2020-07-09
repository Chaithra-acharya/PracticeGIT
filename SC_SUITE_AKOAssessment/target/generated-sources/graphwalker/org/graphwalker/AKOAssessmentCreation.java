// Generated by GraphWalker (http://www.graphwalker.org)
package org.graphwalker;

import org.graphwalker.java.annotation.Model;
import org.graphwalker.java.annotation.Vertex;
import org.graphwalker.java.annotation.Edge;

@Model(file = "org/graphwalker/AKOAssessmentCreation.graphml")
public interface AKOAssessmentCreation {

    @Vertex()
    void v_ValidateAssessmentInfo();

    @Vertex()
    void v_VerifyAssessmentCreation();

    @Edge()
    void e_ClickCreateAssessmentSelectAssessmentType();

    @Edge()
    void e_DeleteExistingAssessment();

    @Vertex()
    void v_VerifyAssessment();
}
