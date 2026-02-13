# Test Cases – Student Information System

| Test Case ID | Scenario                    | Input            | Expected Output            | Result |
| ------------ | --------------------------- | ---------------- | -------------------------- | ------ |
| TC01         | Add valid student           | Age=20, Grade=85 | Student added successfully | Pass   |
| TC02         | Add invalid age             | Age=-5           | Error message              | Pass   |
| TC03         | Add invalid grade           | Grade=150        | Error message              | Pass   |
| TC04         | Duplicate student ID        | ID=S101          | Duplicate ID message       | Pass   |
| TC05         | View students               | Select option 2  | List displayed             | Pass   |
| TC06         | Search existing student     | ID=S101          | Student found              | Pass   |
| TC07         | Search non-existing student | ID=S999          | Not found message          | Pass   |
| TC08         | Update student name         | Change name      | Name updated               | Pass   |
| TC09         | Update student grade        | Change grade     | Grade updated              | Pass   |
| TC10         | Exit system                 | Option 5         | Program closed             | Pass   |
