"I pledge the highest level of ethical principles in support of academic excellence.  I ensure that all of my work reflects my own abilities and not those of someone else."

Answer for the question:
Firstly, We would need to add another button to the 'activity_main.xml' (like the other TextViews).
Then, we would need to add another method to 'SimpleCalculator', which we can call it 'insertMult'.
The method will add the 'x' sign to the output.
In the 'SimpleCalculatorlmpl' we wound need to implement the multiplication behaviour.
In this class we would need to change the 'insertEqual' method.
For testing, we would need to test the new button, to check what happens when it been clicked,
to add some tests to 'AppFlowTest' (which checks the flow) and tests would test the logic in
'SimpleCalculatorlmplTet'.