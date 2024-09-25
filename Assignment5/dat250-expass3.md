# Experiment Assignment 3 - MongoDB Aggregation and CRUD Operations

This report summarizes the steps and results of Experiment 1 (CRUD operations) and Experiment 2 (Aggregation and Map-Reduce) performed using MongoDB on a local environment. The document covers technical challenges encountered, relevant results from CRUD operations, and an example of Map-Reduce from Experiment 2.

## Technical Issues Encountered and Solutions

During the installation of MongoDB, I encountered the following issues:

1. **Problem: Path issues after installation.**  
   * **Solution**: Updated the system PATH environment variable to include the MongoDB binary directory. This ensured that I could access MongoDB from the terminal.

2. **Problem: Unable to start MongoDB as a service.**  
   * **Solution**: After checking the logs, I noticed permission issues. To resolve this, I used `sudo` to give necessary permissions and ensure the service started correctly.

Once these issues were resolved, I was able to proceed with CRUD operations and Map-Reduce successfully.

## Experiment 1: CRUD Operations

### Bulk Insert - `bulk_collection`
I inserted multiple documents into `bulk_collection` as part of the bulk insert operation.

![bulk_screenshot1](https://github.com/user-attachments/assets/56aa83b6-9eab-4d66-95ae-9f229c5b2b07)
![bulk_screenshot2](https://github.com/user-attachments/assets/11e61a7c-a835-48b7-a5a0-de69143ba7f1)

### Insert Operation - `insert_collection`
A single document was inserted into the `insert_collection`.

![insert_screenshot1](https://github.com/user-attachments/assets/266b4edd-b01b-4709-a9be-84c64e39058d)
![insert_screenshot2](https://github.com/user-attachments/assets/7f79ddf6-99e0-4bb7-b136-19689f65cf60)
![insert_screenshot3](https://github.com/user-attachments/assets/2bb6b16b-042b-415e-b04e-4ce1632bdc43)

### Query Operation - `query_collection`
Performed various queries to retrieve data from the `query_collection`.

![query_screenshot1](https://github.com/user-attachments/assets/211536ce-c515-48e9-b823-017680ccfdbb)
![query_screenshot2](https://github.com/user-attachments/assets/18ef1942-b131-4328-9fb5-56624b7d5770)
![query_screenshot3](https://github.com/user-attachments/assets/367b613e-0b25-4d3a-8f5b-6d7e38dc2061)
![query_screenshot4](https://github.com/user-attachments/assets/08b3af75-59a2-425f-9f31-734e99e97faa)
![query_screenshot5](https://github.com/user-attachments/assets/92979eaa-6cc9-469e-8966-f5de66d3345c)
![query_screenshot6](https://github.com/user-attachments/assets/e23bed5e-d52e-43f3-bf35-fd3affaacd53)
![query_screenshot7](https://github.com/user-attachments/assets/021d14d8-adae-4064-8a61-9c43d72227a9)
![query_screenshot8](https://github.com/user-attachments/assets/88a30ddd-901e-4441-b3a7-22a9bbb29374)

### Remove Operation - `remove_collection`
Deleted documents from `remove_collection`.

![remove_screenshot1](https://github.com/user-attachments/assets/2e639581-3acb-4d85-b8d7-32e9e4a82aae)
![remove_screenshot2](https://github.com/user-attachments/assets/7cc28cf1-55bd-4224-94c8-7ea53fdc983d)
![remove_screenshot2](https://github.com/user-attachments/assets/c64e0c0e-7036-4a23-8a28-828ccdd4fae5)
![remove_screenshot3](https://github.com/user-attachments/assets/abd66537-484d-49c5-a88c-09998f87d4ce)

### Update Operation - `update_collection`
Updated specific fields in documents within the `update_collection`.

![update_screenshot1](https://github.com/user-attachments/assets/14362465-77dc-47f7-8a0e-379a500e54d4)
![update_screenshot2](https://github.com/user-attachments/assets/2f02d5f2-92e0-4ba4-925a-2134433a26a8)
![update_screenshot3](https://github.com/user-attachments/assets/2d8c601b-cb87-460e-8961-eed7e4b150ae)
![update_screenshot4](https://github.com/user-attachments/assets/b53776df-7ed2-4512-b483-da7418d78028)
![update_screenshot5](https://github.com/user-attachments/assets/93be246c-4734-4d89-9881-1a3a647496ec)
![update_screenshot6](https://github.com/user-attachments/assets/b2c6ceba-3c0d-42fb-86ce-2332d089fafe)

## Experiment 2: Map-Reduce Operation

### Map-Reduce Example

In this experiment, a Map-Reduce operation was used to calculate the total quantity of each product sold. The `map` function emits the product and the quantity, while the `reduce` function sums up the quantities for each product.

Here are two screenshots which shows the results os the Map-Reduce operation:

![map_reduce_screenshot1](https://github.com/user-attachments/assets/09e55b7c-4839-44ee-8583-1a9e3f0c7a8e)
![map_reduce_screenshot2](https://github.com/user-attachments/assets/87b0e84b-67fd-4e61-9576-02bf1ef3eff4)

## Usefulness and Interpretation of Map-Reduce Operation

The Map-Reduce operation implemented here is useful for aggregating data, especially when dealing with large datasets. By mapping product quantities and then reducing them by summing the values, we can efficiently calculate the total quantity of each product sold across many documents.

## Unresolved Issues

No major issues were encountered during the completion of this experiment. All operations were performed successfully, and results were as expected.

## Conclusion

In this experiment, we successfully implemented and validated CRUD operations in MongoDB, followed by a Map-Reduce operation to aggregate sales data. The steps demonstrate the practical application of MongoDB in processing and aggregating large datasets efficiently.
