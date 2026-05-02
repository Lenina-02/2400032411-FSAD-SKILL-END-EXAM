# Supplier Order Management System

## Project Details
- **Package Structure**: `com.klef.fsad.exam`
- **Database Name**: `fsadendexam`
- **Database Type**: H2 (In-Memory)
- **Server Port**: 8080

## Project Structure
```
supplier-order-app/
├── src/
│   └── main/
│       ├── java/
│       │   └── com/
│       │       └── klef/
│       │           └── fsad/
│       │               └── exam/
│       │                   ├── SupplierOrderApplication.java (Main Class)
│       │                   ├── model/
│       │                   │   └── SupplierOrder.java (Entity)
│       │                   ├── repository/
│       │                   │   └── SupplierOrderRepository.java
│       │                   ├── service/
│       │                   │   └── SupplierOrderService.java
│       │                   └── controller/
│       │                       └── SupplierOrderController.java
│       └── resources/
│           └── application.properties
├── pom.xml
└── SupplierOrderAPI.postman_collection.json
```

## Features Implemented
✅ POST - Add SupplierOrder (Manual ID required)
✅ GET - Get all SupplierOrders
✅ GET - Get SupplierOrder by ID
✅ PUT - Update SupplierOrder
✅ DELETE - Delete SupplierOrder
✅ Package structure: com.klef.fsad.exam
✅ Database name: fsadendexam
✅ Proper naming conventions

## How to Run

### Prerequisites
- Java 17 or higher
- Maven 3.6+
- Any IDE (IntelliJ IDEA, Eclipse, VS Code with Java extensions)

### Steps to Run in VS Code

1. **Open the project in VS Code**
   - Open VS Code
   - File → Open Folder
   - Select the `supplier-order-app` folder

2. **Install Required Extensions** (if not already installed)
   - Extension Pack for Java
   - Spring Boot Extension Pack

3. **Run the Application**
   - Open `SupplierOrderApplication.java`
   - Click on "Run" above the main method
   - OR press F5
   - OR use terminal: `mvn spring-boot:run`

4. **Verify Application Started**
   - Look for message: "Supplier Order Application Started Successfully!"
   - Application runs at: http://localhost:8080

## Testing the API

### Option 1: Using Postman
1. Import the file `SupplierOrderAPI.postman_collection.json` into Postman
2. Run the requests in order:
   - Add SupplierOrder (POST)
   - Get All SupplierOrders (GET)
   - Get SupplierOrder by ID (GET)
   - Update SupplierOrder (PUT)
   - Delete SupplierOrder (DELETE)

### Option 2: Using cURL (Command Line)

**1. Add SupplierOrder (POST)**
```bash
curl -X POST http://localhost:8080/api/supplier-orders \
-H "Content-Type: application/json" \
-d '{
  "supplierOrderId": 1001,
  "name": "Office Supplies Order",
  "date": "2024-05-15",
  "status": "Pending",
  "amount": 5000.00,
  "description": "Monthly office supplies procurement"
}'
```

**2. Get All SupplierOrders (GET)**
```bash
curl http://localhost:8080/api/supplier-orders
```

**3. Get SupplierOrder by ID (GET)**
```bash
curl http://localhost:8080/api/supplier-orders/1001
```

**4. Update SupplierOrder (PUT)**
```bash
curl -X PUT http://localhost:8080/api/supplier-orders/1001 \
-H "Content-Type: application/json" \
-d '{
  "name": "Office Supplies Order - Updated",
  "date": "2024-05-15",
  "status": "Completed",
  "amount": 5500.00,
  "description": "Monthly office supplies procurement - Delivered"
}'
```

**5. Delete SupplierOrder (DELETE)**
```bash
curl -X DELETE http://localhost:8080/api/supplier-orders/1001
```

### Option 3: Using Web Browser (for GET requests only)
- Get All: http://localhost:8080/api/supplier-orders
- Get by ID: http://localhost:8080/api/supplier-orders/1001

## Database Access
- H2 Console: http://localhost:8080/h2-console
- JDBC URL: `jdbc:h2:mem:fsadendexam`
- Username: `sa`
- Password: (leave blank)

## API Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | /api/supplier-orders | Add new SupplierOrder |
| GET | /api/supplier-orders | Get all SupplierOrders |
| GET | /api/supplier-orders/{id} | Get SupplierOrder by ID |
| PUT | /api/supplier-orders/{id} | Update SupplierOrder |
| DELETE | /api/supplier-orders/{id} | Delete SupplierOrder |

## Important Notes

1. **SupplierOrder ID**: Must be provided manually when creating a new order. It cannot be null.
2. **Required Fields**: supplierOrderId, name, date, status
3. **Optional Fields**: amount, description

## Example Request Body (POST)
```json
{
  "supplierOrderId": 1001,
  "name": "Office Supplies Order",
  "date": "2024-05-15",
  "status": "Pending",
  "amount": 5000.00,
  "description": "Monthly office supplies procurement"
}
```

## Troubleshooting

1. **Port 8080 already in use**
   - Change port in `application.properties`: `server.port=8081`

2. **Maven dependencies not downloading**
   - Run: `mvn clean install`

3. **Application not starting**
   - Check Java version: `java -version` (should be 17+)
   - Check Maven version: `mvn -version`

## Presenting to Teacher

1. Start the application
2. Open Postman and import the collection
3. Demonstrate each operation:
   - Create a new order (POST)
   - Show all orders (GET)
   - Show specific order (GET by ID)
   - Update the order (PUT)
   - Delete the order (DELETE)
4. Show the H2 database console with data

Good luck with your presentation! 🚀
