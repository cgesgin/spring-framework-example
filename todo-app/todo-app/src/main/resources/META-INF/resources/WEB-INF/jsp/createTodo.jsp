<%@ include file="header.jsp" %>
    <%@ include file="navigation.jsp" %>

        <div class="container">
            <h3>hello ${name}</h3>
            <br>
            <h1 class="container">Enter Details</h1>
            <hr />
            <form:form method="Post" modelAttribute="todo">

            <fieldset class="mb-3">				
                <form:label path="description">Description</form:label>
                <form:input type="text" path="description" required="required"/>
                <form:errors path="description" cssClass="text-warning"/>
            </fieldset>
    
            <fieldset class="mb-3">				
                <form:label path="targetDate">Target Date</form:label>
                <form:input type="text" path="targetDate" required="required"/>
                <form:errors path="targetDate" cssClass="text-warning"/>
            </fieldset>
    
            
            <form:input type="hidden" path="id"/>
    
            <form:input type="hidden" path="status"/>
    
            <input type="submit" class="btn btn-success" value="save"/>
        
        </form:form>
        </div>

        <%@ include file="footer.jsp" %>

            <script type="text/javascript">
                $('#targetDate').datepicker({
                    format: 'dd-mm-yyyy'
                });
            </script>