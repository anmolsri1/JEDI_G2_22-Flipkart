package com.flipkart.app.usermenus;

import com.flipkart.exception.*;

public interface UserMenu {
    void showMenu() throws StudentNotFoundForApprovalException, UserIdAlreadyInUseException, ProfessorNotAddedException, CourseExistsAlreadyException, CourseNotDeletedException, CourseNotFoundException, UserNotFoundException;
}
