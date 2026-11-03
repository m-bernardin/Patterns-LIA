# Deliverable 1 Documents
## Project Features

## User Interface Plan

## Team Members and Responsibilites
| Name | Features |
| --- | --- |
| Mathieu Bernardin | |

## User Stories

## Entity Relationship Diagram

```mermaid
erDiagram

    User ||--O{ Subscription : submits
    Subscription }O--|| Conference : has

    User {
        **PK** user_id
        TEXT fname
        TEXT email
        INTEGER age
        TEXT password
        TEXT usertype
        
    }

    Subscription {
        **PK** subscription_id
        **FK** user_id
        **FK** conference_id
        TEXT isOnWaitingList
    }

    Conference {
        TEXT conference_id
        TEXT title
        INTEGER capacity
        DATE start_date
        DATE end_date
        TEXT location
    }
```
